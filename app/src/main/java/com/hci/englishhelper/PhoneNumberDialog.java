package com.hci.englishhelper;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import static com.hci.englishhelper.MainActivity.PREFS_NAME;

public class PhoneNumberDialog extends DialogFragment {
    private String text;
    public String getPhone() {
        return text;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        final LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        final View dialogView = inflater.inflate(R.layout.setting_dialog, null);
        builder.setView(dialogView);

        SharedPreferences settings = getActivity().getSharedPreferences(PREFS_NAME, 0);
        EditText editText = dialogView.findViewById(R.id.phone);
        editText.setText(settings.getString("phone", ""));

        builder.setMessage(R.string.setting_title)
                .setPositiveButton(R.string.setting_confirm, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        EditText editText = dialogView.findViewById(R.id.phone);
                        text = editText.getText().toString();

                        // Send the positive button event back to the host activity
                        mListener.onDialogPositiveClick(PhoneNumberDialog.this);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Send the negative button event back to the host activity
                        mListener.onDialogNegativeClick(PhoneNumberDialog.this);
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

    /* The activity that creates an instance of this dialog fragment must
     * implement this interface in order to receive event callbacks.
     * Each method passes the DialogFragment in case the host needs to query it. */
    public interface PhoneDialogListener {
        public void onDialogPositiveClick(PhoneNumberDialog dialog);
        public void onDialogNegativeClick(PhoneNumberDialog dialog);
    }

    // Use this instance of the interface to deliver action events
    PhoneDialogListener mListener;

    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (PhoneDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");
        }
    }
}
