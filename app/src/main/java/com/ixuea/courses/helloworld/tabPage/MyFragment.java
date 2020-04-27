package com.ixuea.courses.helloworld.tabPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {
    private final String title;
    private final int xml;

    MyFragment(String title, int xml){
        super();
        this.title = title;
        this.xml = xml;
    }
    String getTitle(){
        return title;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(xml,container,false);
    }

}
