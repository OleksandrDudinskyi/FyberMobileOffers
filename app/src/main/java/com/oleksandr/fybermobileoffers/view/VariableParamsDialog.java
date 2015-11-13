package com.oleksandr.fybermobileoffers.view;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.oleksandr.fybermobileoffers.R;

/**
 * @author o.dudinskyi(dudinskyj@gmail.com)
 */
public class VariableParamsDialog extends DialogFragment {

    private EditText mUidEditTxt;
    private EditText mAPIKeyEditTxt;
    private EditText mAppIDEditTxt;
    private EditText mPub0EditTxt;
    private AppCompatButton mSendRequestBtn;

    public VariableParamsDialog() {
        // Empty constructor required for DialogFragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.variable_params_layout, container);
        mUidEditTxt = (EditText) view.findViewById(R.id.uid_edit_txt);
        mAPIKeyEditTxt = (EditText) view.findViewById(R.id.api_key_edit_txt);
        mAppIDEditTxt = (EditText) view.findViewById(R.id.appid_edit_txt);
        mPub0EditTxt = (EditText) view.findViewById(R.id.pub0_edit_txt);
        mSendRequestBtn = (AppCompatButton) view.findViewById(R.id.send_request_btn);
        mSendRequestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).sendRequest();
            }
        });
        return view;
    }
}
