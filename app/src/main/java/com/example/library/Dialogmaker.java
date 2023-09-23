package com.example.library;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class Dialogmaker extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setPositiveButton(R.string.dialog_btn_ok,new DialogButtonClickListener());
        //builder.setMessage(R.string.dialog_msg,new DialogButtonClickListener());
        AlertDialog dialog= builder.create();
        return dialog;
    }
    private class  DialogButtonClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which){
            String msg ="";
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:

            }
        }
    }
}
