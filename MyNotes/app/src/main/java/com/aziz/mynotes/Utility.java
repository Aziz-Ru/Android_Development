package com.aziz.mynotes;

import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;

public class Utility {
    static CollectionReference getCollectionReferenceNote(){
        FirebaseUser current_user= FirebaseAuth.getInstance().getCurrentUser();

        return FirebaseFirestore.getInstance().collection("notes")
                .document(current_user.getUid()).collection("my_notes");
    }
    static String timestamptoString(Timestamp timestamp){
        return new SimpleDateFormat("dd/MM/yyyy").format(timestamp.toDate());
    }
}
