package com.example.fitnesstracker;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDialogFragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import java.util.Date;
import java.util.Objects;

public class ServingDialog extends AppCompatDialogFragment {
    private EditText serving_size_Edittext;
    private double calories;
    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = Objects.requireNonNull(getActivity()).getLayoutInflater();
        View view = inflater.inflate(R.layout.adjust_serving_size,null);
        builder.setView(view)
                .setTitle("")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        double servingNo = Integer.parseInt(serving_size_Edittext.getText().toString());
                        calories *= servingNo;
                        Intake intake = new Intake(new Date(),calories);
                        User user = UserInSession.getUser();
                        user.addIntake(intake);
                    }
                });
        serving_size_Edittext = view.findViewById(R.id.serving_size_edittext);
        return builder.create();
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }
}
