/*
 ************************************************
 * project:      Level
 * package name: com.kssoftwaresolutionsgbr.level
 * class:        Calculation
 * dev:          Malte Schoenert
 * created on:   2021-01-06
 ************************************************
 */

package com.kssoftwaresolutionsgbr.level;

import android.os.TestLooperManager;

public class Calculation {

    // fields

    // constructors

    // methods
    public Alignment get_alignment(float mx, float my, float mz) throws CustomExceptions.CalculationException {
        if(mx >= 0 && my >= 0){
            if(my > mx){
                return Alignment.UPWARD;
            }
            else if(my < mx){
                return Alignment.LEFTWARD;
            }
        }
        else if(mx >= 0 && my < 0){
            if (mx > Math.abs(my)){
                return Alignment.LEFTWARD;
            }
            else if(mx < Math.abs(my)){
                return Alignment.DOWNWARD;
            }
        }
        else if(mx < 0 && my < 0){
            if(mx > my){
                return Alignment.DOWNWARD;
            }
            else if(mx < my){
                return Alignment.RIGHTWARD;
            }
        }
        else if(mx < 0 && my >= 0){
            if(Math.abs(mx) > my){
                return Alignment.RIGHTWARD;
            }
            else if (Math.abs(mx) < my){
                return Alignment.UPWARD;
            }
        }

        throw new CustomExceptions.CalculationException();
    }
}
