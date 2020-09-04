package com.lupinesoft.livedata_demo;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.Random;

public class MainActivityViewModel extends ViewModel {

    MutableLiveData<String> randomNumber;

    public MutableLiveData<String> getNumber(){
        Log.d("TAG","getNumber");
        if(randomNumber == null){
            randomNumber = new MutableLiveData<>();
            createNumber();
        }
        return randomNumber;
    }

    public void createNumber(){
        Log.d("TAG","createNumber");
        Random random = new Random();
        randomNumber.setValue("Number: "+(random.nextInt(100-1)+1));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("TAG","onCleared");
    }
}
