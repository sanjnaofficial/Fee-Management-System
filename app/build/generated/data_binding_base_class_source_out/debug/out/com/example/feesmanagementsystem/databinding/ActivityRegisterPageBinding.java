// Generated by view binder compiler. Do not edit!
package com.example.feesmanagementsystem.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.feesmanagementsystem.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityRegisterPageBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final EditText PhoneNo;

  @NonNull
  public final Button btnRegister;

  @NonNull
  public final EditText email;

  @NonNull
  public final EditText name;

  @NonNull
  public final EditText password;

  @NonNull
  public final EditText regNo;

  private ActivityRegisterPageBinding(@NonNull LinearLayout rootView, @NonNull EditText PhoneNo,
      @NonNull Button btnRegister, @NonNull EditText email, @NonNull EditText name,
      @NonNull EditText password, @NonNull EditText regNo) {
    this.rootView = rootView;
    this.PhoneNo = PhoneNo;
    this.btnRegister = btnRegister;
    this.email = email;
    this.name = name;
    this.password = password;
    this.regNo = regNo;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityRegisterPageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityRegisterPageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_register_page, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityRegisterPageBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.PhoneNo;
      EditText PhoneNo = ViewBindings.findChildViewById(rootView, id);
      if (PhoneNo == null) {
        break missingId;
      }

      id = R.id.btn_register;
      Button btnRegister = ViewBindings.findChildViewById(rootView, id);
      if (btnRegister == null) {
        break missingId;
      }

      id = R.id.email;
      EditText email = ViewBindings.findChildViewById(rootView, id);
      if (email == null) {
        break missingId;
      }

      id = R.id.name;
      EditText name = ViewBindings.findChildViewById(rootView, id);
      if (name == null) {
        break missingId;
      }

      id = R.id.password;
      EditText password = ViewBindings.findChildViewById(rootView, id);
      if (password == null) {
        break missingId;
      }

      id = R.id.regNo;
      EditText regNo = ViewBindings.findChildViewById(rootView, id);
      if (regNo == null) {
        break missingId;
      }

      return new ActivityRegisterPageBinding((LinearLayout) rootView, PhoneNo, btnRegister, email,
          name, password, regNo);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
