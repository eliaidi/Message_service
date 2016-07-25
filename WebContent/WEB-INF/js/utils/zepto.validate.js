/* zepto表单校验 
 * @ Author: lizhiyang1
 * @ Date: 2016-03-08
 */
;(function(defaults, $, window, undefined) {

    var type = ['input[type="password"],input[type="text"],input[type="tel"]'],
        allTypes = type.join(','),
        extend = {};

    var validateField = function(event, options) {
        var status = {
                pattern : true,
                conditional : true,
                required : true
            },
            field = $(this),
            fieldValue = field.val() || '',
            fieldValidate = field.data('validate'),
            validation = fieldValidate !== undefined ? extend[fieldValidate] : {},
            fieldPrepare = field.data('prepare') || validation.prepare,
            fieldPattern = (field.data('pattern') || ($.type(validation.pattern) == 'regexp' ? validation.pattern : /(?:)/)),
            fieldIgnoreCase = field.attr('data-ignore-case') || field.data('ignoreCase') || validation.ignoreCase,
            fieldMask = field.data('mask') || validation.mask,
            fieldConditional = field.data('conditional') || validation.conditional,
            fieldRequired = field.data('required'),
            fieldDescribedby = field.data('describedby') || validation.describedby,
            fieldDescription = field.data('description') || validation.description,
            fieldTrim = field.data('trim'),
            reTrue = /^(true|)$/i,
            reFalse = /^false$/i,
            fieldDescription = $.isPlainObject(fieldDescription) ? fieldDescription : (options.description[fieldDescription] || {}),
            name = 'validate';

        fieldRequired = fieldRequired != '' ? (fieldRequired || !!validation.required) : true;
        fieldTrim = fieldTrim != '' ? (fieldTrim || !!validation.trim) : true;

        if(reTrue.test(fieldTrim)) {
            fieldValue = $.trim(fieldValue);
        }

        if($.isFunction(fieldPrepare)) {
            fieldValue = String(fieldPrepare.call(field, fieldValue));
        } else {
            if($.isFunction(options.prepare[fieldPrepare])) {
                fieldValue = String(options.prepare[fieldPrepare].call(field, fieldValue));
            }
        }

        if($.type(fieldPattern) != 'regexp') {
            fieldIgnoreCase = !reFalse.test(fieldIgnoreCase);
            fieldPattern = fieldIgnoreCase ? RegExp(fieldPattern, 'i') : RegExp(fieldPattern);
        }

        if(fieldConditional != undefined) {
            if($.isFunction(fieldConditional)) {
                status.conditional = !!fieldConditional.call(field, fieldValue, options);
            } else {
                var conditionals = fieldConditional.split(/[\s\t]+/);
                for(var counter = 0, len = conditionals.length; counter < len; counter++) {
                    if(options.conditional.hasOwnProperty(conditionals[counter]) && !options.conditional[conditionals[counter]].call(field, fieldValue, options)) {
                        status.conditional = false;
                    }
                }
            }
        }

        fieldRequired = reTrue.test(fieldRequired);

        if(fieldRequired) {
            if(field.is(type[0] + ',' + type[1])) {
                if(!fieldValue.length > 0) {
                    status.required = false;
                }
            } else if(field.is(type[2])) {
                if(field.is('[name]')) {
                    if($('[name="' + field.prop('name') + '"]:checked').length == 0) {
                        status.required = false;
                    }
                } else {
                    status.required = field.is(':checked');
                }
            }
        }

        if(field.is(type[0])) {
            if(fieldPattern.test(fieldValue)) {
                if(event.type != 'keyup' && fieldMask !== undefined) {
                    var matches = fieldValue.match(fieldPattern);
                    for(var i = 0, len = matches.length; i < len; i++) {
                        fieldMask = fieldMask.replace(RegExp('\\$\\{' + i + '(?::`([^`]*)`)?\\}', 'g'), (matches[i] !== undefined ? matches[i] : '$1'));
                    }

                    fieldMask = fieldMask.replace(/\$\{\d+(?::`([^`]*)`)?\}/g, '$1');

                    if(fieldPattern.test(fieldMask)) {
                        field.val(fieldMask);
                    }
                }
            } else {
                if(fieldRequired) {
                    status.pattern = false;
                } else {
                    if(fieldValue.length > 0) {
                        status.pattern = false;
                    }
                }
            }
        }

        var describedby = $('[id="' + fieldDescribedby +'"]'),
            log = fieldDescription.valid;

        if(describedby.length > 0 && event.type != 'keyup') {
            if(!status.required) {
                log = fieldDescription.required;
            } else if(!status.pattern) {
                log = fieldDescription.pattern;
            } else if(!status.conditional) {
                log = fieldDescription.conditional;
            }
            describedby.html(log || '');
        }

        if(typeof(validation.each) == 'function') {
            validation.each.call(field, event, status, options);
        }

        options.eachField.call(field, event, status, options);

        if(status.required && status.pattern && status.conditional) {
            if(typeof(validation.valid) == 'function') {
                validation.valid.call(field, event, status, options);
            }
            options.eachValidField.call(field, event, status, options);
        } else {
            if(typeof(validation.invalid) == 'function') {
                validation.invalid.call(field, event, status, options);
            }

            options.eachInvalidField.call(field, event, status, options);
        }
        return status;
    };

    $.extend($.fn,{
        validate : function(options) {

            options = $.extend({}, defaults, options);

            return $(this).validateDestroy().each(function() {

                var form = $(this);

                form.data(name, {
                    options : options
                });

                var fields = form.find(allTypes),
                    namespace = options.namespace;
                if(form.is('[id]')) {
                    fields = fields.add('[form="' + form.prop('id') + '"]').filter(allTypes);
                }
                fields = fields.filter(options.filter);
                if(!!options.onPropChange) {
                    fields.filter(type[0]).bind('input propertychange', function(event) {
                        validateField.call(this, event, options);

                        var formValid = true;
                        fields.each(function() {
                            var status = validateField.call(this, event, options);
                            if(!status.pattern || !status.conditional || !status.required) {
                                formValid = false;
                            }
                        });
                        if(formValid) {
                            options.validSuccess.call(form, event, options);
                        }else{
                            options.validError.call(form, event, options);
                        }
                    });
                }
                if(!!options.onChange) {
                    fields.filter(type[0]).bind('focus input propertychange keyup.' + namespace, function(event) {
                        validateField.call(this, event, options);

                        var formValid = true;
                        fields.each(function() {
                            var status = validateField.call(this, event, options);
                            if(!status.pattern || !status.conditional || !status.required) {
                                formValid = false;
                            }
                        });
                        if(formValid) {
                            options.validSuccess.call(form, event, options);
                        }else{
                            options.validError.call(form, event, options);
                        }
                    });
                }
                if(!!options.onBlur) {
                    fields.on('blur.' + namespace, function(event) {
                        validateField.call(this, event, options);

                        var formValid = true;
                        fields.each(function() {
                            var status = validateField.call(this, event, options);
                            if(!status.pattern || !status.conditional || !status.required) {
                                formValid = false;
                            }
                        });
                        if(formValid) {
                            options.validSuccess.call(form, event, options);
                        }else{
                            options.validError.call(form, event, options);
                        }
                    });
                }
                if(!!options.onSubmit) {
                    form.on('submit.' + namespace, function(event) {
                        var formValid = true;
                        fields.each(function() {
                            var status = validateField.call(this, event, options);
                            if(!status.pattern || !status.conditional || !status.required) {
                                formValid = false;
                            }
                        });
                        if(formValid) {
                            if(!options.sendForm) {
                                event.preventDefault();
                            }
                            if($.isFunction(options.valid)) {
                                options.valid.call(form, event, options);
                            }
                        } else {
                            event.preventDefault();
                            event.stopImmediatePropagation();
                            if($.isFunction(options.invalid)) {
                                options.invalid.call(form, event, options);
                            }
                        }
                    });
                }
            });
        },
        validateDestroy : function() {
            var form = $(this),
                dataValidate = form.data(name);
            if(form.is('form') && $.isPlainObject(dataValidate) && typeof(dataValidate.options.nameSpace) == 'string') {
                var fields = form.removeData(name).find(allTypes).add(form);
                if(form.is('[id]')) {
                    fields = fields.add($('[form="' + form.prop('id') + '"]').filter(allTypes));
                }
                fields.off('.' + dataValidate.options.nameSpace);
            }
            return form;
        }
    });

})({
    sendForm : false,
    onSubmit : false,
    onKeyup : false,
    onBlur : false,
    onChange : false,
    onPropChange: false,
    nameSpace : 'validate',
    filter : '*',
    conditional : {},
    prepare : {},
    description : {},
    eachField : function(){},
    eachInvalidField : function(){},
    eachValidField : function(){},
    validSuccess : function(){},
    validError : function(){},
    invalid : function(){},
    valid : function(){}
},Zepto, window);