// Generated by view binder compiler. Do not edit!
package com.example.feesmanagementsystem.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.feesmanagementsystem.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityListOfStudentsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button callbtn;

  @NonNull
  public final TextView emailTV;

  @NonNull
  public final Button emailbtn;

  @NonNull
  public final TextView feesPendingTV;

  @NonNull
  public final TextView feesTotalTV;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final LinearLayout linearLayout2;

  @NonNull
  public final LinearLayout linearLayout3;

  @NonNull
  public final LinearLayout linearLayout4;

  @NonNull
  public final LinearLayout linearLayout5;

  @NonNull
  public final LinearLayout linearLayout6;

  @NonNull
  public final LinearLayout ll1;

  @NonNull
  public final TextView nameTV;

  @NonNull
  public final TextView phoneTV;

  @NonNull
  public final TextView regTV;

  @NonNull
  public final TextView textView2;

  private ActivityListOfStudentsBinding(@NonNull ConstraintLayout rootView, @NonNull Button callbtn,
      @NonNull TextView emailTV, @NonNull Button emailbtn, @NonNull TextView feesPendingTV,
      @NonNull TextView feesTotalTV, @NonNull LinearLayout linearLayout,
      @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3,
      @NonNull LinearLayout linearLayout4, @NonNull LinearLayout linearLayout5,
      @NonNull LinearLayout linearLayout6, @NonNull LinearLayout ll1, @NonNull TextView nameTV,
      @NonNull TextView phoneTV, @NonNull TextView regTV, @NonNull TextView textView2) {
    this.rootView = rootView;
    this.callbtn = callbtn;
    this.emailTV = emailTV;
    this.emailbtn = emailbtn;
    this.feesPendingTV = feesPendingTV;
    this.feesTotalTV = feesTotalTV;
    this.linearLayout = linearLayout;
    this.linearLayout2 = linearLayout2;
    this.linearLayout3 = linearLayout3;
    this.linearLayout4 = linearLayout4;
    this.linearLayout5 = linearLayout5;
    this.linearLayout6 = linearLayout6;
    this.ll1 = ll1;
    this.nameTV = nameTV;
    this.phoneTV = phoneTV;
    this.regTV = regTV;
    this.textView2 = textView2;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityListOfStudentsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityListOfStudentsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_list_of_students, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityListOfStudentsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.callbtn;
      Button callbtn = ViewBindings.findChildViewById(rootView, id);
      if (callbtn == null) {
        break missingId;
      }

      id = R.id.emailTV;
      TextView emailTV = ViewBindings.findChildViewById(rootView, id);
      if (emailTV == null) {
        break missingId;
      }

      id = R.id.emailbtn;
      Button emailbtn = ViewBindings.findChildViewById(rootView, id);
      if (emailbtn == null) {
        break missingId;
      }

      id = R.id.feesPendingTV;
      TextView feesPendingTV = ViewBindings.findChildViewById(rootView, id);
      if (feesPendingTV == null) {
        break missingId;
      }

      id = R.id.feesTotalTV;
      TextView feesTotalTV = ViewBindings.findChildViewById(rootView, id);
      if (feesTotalTV == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.linearLayout2;
      LinearLayout linearLayout2 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout2 == null) {
        break missingId;
      }

      id = R.id.linearLayout3;
      LinearLayout linearLayout3 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout3 == null) {
        break missingId;
      }

      id = R.id.linearLayout4;
      LinearLayout linearLayout4 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout4 == null) {
        break missingId;
      }

      id = R.id.linearLayout5;
      LinearLayout linearLayout5 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout5 == null) {
        break missingId;
      }

      id = R.id.linearLayout6;
      LinearLayout linearLayout6 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout6 == null) {
        break missingId;
      }

      id = R.id.ll1;
      LinearLayout ll1 = ViewBindings.findChildViewById(rootView, id);
      if (ll1 == null) {
        break missingId;
      }

      id = R.id.nameTV;
      TextView nameTV = ViewBindings.findChildViewById(rootView, id);
      if (nameTV == null) {
        break missingId;
      }

      id = R.id.phoneTV;
      TextView phoneTV = ViewBindings.findChildViewById(rootView, id);
      if (phoneTV == null) {
        break missingId;
      }

      id = R.id.regTV;
      TextView regTV = ViewBindings.findChildViewById(rootView, id);
      if (regTV == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      return new ActivityListOfStudentsBinding((ConstraintLayout) rootView, callbtn, emailTV,
          emailbtn, feesPendingTV, feesTotalTV, linearLayout, linearLayout2, linearLayout3,
          linearLayout4, linearLayout5, linearLayout6, ll1, nameTV, phoneTV, regTV, textView2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
