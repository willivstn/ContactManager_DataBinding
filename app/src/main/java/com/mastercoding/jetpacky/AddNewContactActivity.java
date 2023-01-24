package com.mastercoding.jetpacky;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;
import com.mastercoding.jetpacky.databinding.ActivityAddNewContactBinding;

public class AddNewContactActivity extends AppCompatActivity {


    private ActivityAddNewContactBinding activityAddNewContactBinding;
    Contact contact;
    private AddNewContactActivityClickHandlers addNewContactActivityClickHandlers;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);



        contact = new Contact();
        activityAddNewContactBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_contact);
        activityAddNewContactBinding.setContact(contact);

        addNewContactActivityClickHandlers = new AddNewContactActivityClickHandlers(this);
        activityAddNewContactBinding.setClickHandler(addNewContactActivityClickHandlers);




    }


    public class AddNewContactActivityClickHandlers{
        Context context;

        public AddNewContactActivityClickHandlers(Context context) {
            this.context = context;
        }


        public void onSubmitClicked(View view){

            if (contact.getName() == null){
                Toast.makeText(getApplicationContext(), "Fields cannot be empty", Toast.LENGTH_SHORT).show();
            }
            else{
                Intent i = new Intent();
                i.putExtra("NAME", contact.getName());
                i.putExtra("EMAIL", contact.getEmail());


                setResult(RESULT_OK, i);
                finish();


            }
        }


    }




}