package com.hotelspro.challange.burak.karatas.controllers.validators;

/**
 * Created by bkaratas on 5/8/17.
 */
public abstract class AbstractValidator implements IValidator {

    protected AbstractValidator nextValidator = null;

    public AbstractValidator setNextValidator(AbstractValidator nextValidator) {
        this.nextValidator = nextValidator;
        return this.nextValidator;
    }

    protected String getSimpleClassName() {
        return this.getClass().getSimpleName();
    }

}
