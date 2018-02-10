package com.example.kolyaservit.retrofitexample.Rx;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import io.reactivex.Observable;
import io.reactivex.internal.operators.observable.ObservableDebounce;
import io.reactivex.subjects.PublishSubject;

public class RxEditText {
    public static Observable<String> addTextWatcher(EditText editor) {
        PublishSubject<String> subject = PublishSubject.create();
        editor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                subject.onNext(s.toString());
            }
        });
        return subject;
    }
}
