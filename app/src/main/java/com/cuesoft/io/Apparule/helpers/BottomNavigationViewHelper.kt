package com.cuesoft.io.apparule.helpers

import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigationViewHelper {

    fun disableShiftMode(view : BottomNavigationView){
        val  menuView : BottomNavigationMenuView = view.getChildAt(0) as BottomNavigationMenuView

        try{
            val shiftingMode : BottomNavigationMenuView =  menuView.javaClass.getDeclaredField( "mShiftingMode") as BottomNavigationMenuView
            //shiftingMode.acces
        }catch( e : NoSuchFieldException){

        }

    }
}