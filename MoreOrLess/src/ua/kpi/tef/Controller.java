package ua.kpi.tef;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View  view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    // The Work method
    public void processUser(){
        Scanner sc = new Scanner(System.in);

        while (!model.checkMinBarrier(inputMinValueWithScanner(sc))){}

        while (!model.checkMaxBarrier(inputMaxValueWithScanner(sc))){}

        model.setSecretValue();

        while (!model.checkValue(inputIntValueWithScanner(sc))){}

        view.printCongratulation(model);
        view.printWay(model);
    }

    private int inputMinValueWithScanner(Scanner sc) {
        int res=0;
        view.printMessage(view.getInputMinBMessage());

        while( true ) {
            // check min - value
            while (!sc.hasNextInt()) {
                view.printWrongMinValueInput();
                sc.next();
            }
            // check value in diapason
            if ((res = sc.nextInt()) < GlobalConstants.PRIMARY_MIN_BARRIER ||
                    res > GlobalConstants.PRIMARY_MAX_BARRIER) {
                view.printWrongMinValueInput();
                //continue;
            }
            break;
        }
        return res;
    }

    private int inputMaxValueWithScanner(Scanner sc) {
        int res=0;
        int minBarier = model.getMinBarrier();
        view.printMessage(view.getInputMaxBMessage(minBarier));

        while( true ) {
            // check max - value
            while (!sc.hasNextInt()) {
                view.printWrongMaxValueInput(model);
                sc.next();
            }
            // check value in diapason
            if ((res = sc.nextInt()) <= minBarier +1 ||
                    res > GlobalConstants.PRIMARY_MAX_BARRIER) {
                view.printWrongMaxValueInput(model);
                continue ;
            }
            break;
        }
        return res;
    }

    // The Utility methods
    private int inputIntValueWithScanner(Scanner sc) {
        int res=0;
        view.printMessage(view.getInputMessage
                (model.getMinBarrier(), model.getMaxBarrier()));

        while( true ) {
            // check int - value
            while (!sc.hasNextInt()) {
                view.printWrongIntInput(model);
                sc.next();
            }
            // check value in diapason
            if ((res = sc.nextInt()) <= model.getMinBarrier() ||
                    res >= model.getMaxBarrier()) {
                view.printWrongRangeInput(model);
                continue ;
            }
            break;
        }
        return res;
    }
}
