package com.hotelspro.challange.burak.karatas.controllers.validators;

/**
 * Created by bkaratas on 5/8/17.
 */
public class ValidatorGenerator {

    public static IValidator getBaseValidator() {
        HeaderExistValidator one = new HeaderExistValidator();
        BodyExistValidator two = new BodyExistValidator();
        NullCheckValidator three = new NullCheckValidator();
        one.setNextValidator(two);
        two.setNextValidator(three);
        return one;
    }

    public static IValidator getDivisionValidator() {
        HeaderExistValidator one = new HeaderExistValidator();
        BodyExistValidator two = new BodyExistValidator();
        NullCheckValidator three = new NullCheckValidator();
        DivZeroValidator four = new DivZeroValidator();

        one.setNextValidator(two);
        two.setNextValidator(three);
        three.setNextValidator(four);

        return one;
    }


}
