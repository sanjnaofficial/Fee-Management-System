// Generated by view binder compiler. Do not edit!
package com.example.feesmanagementsystem.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.feesmanagementsystem.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHome4Binding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button addFeesButton;

  @NonNull
  public final EditText feesAmountEdittext;

  @NonNull
  public final ListView feesListview;

  @NonNull
  public final ImageView profilePicture;

  @NonNull
  public final ImageView qrCodeImageview;

  @NonNull
  public final EditText studentNameEdittext;

  @NonNull
  public final TextView textView;

  private FragmentHome4Binding(@NonNull LinearLayout rootView, @NonNull Button addFeesButton,
      @NonNull EditText feesAmountEdittext, @NonNull ListView feesListview,
      @NonNull ImageView profilePicture, @NonNull ImageView qrCodeImageview,
      @NonNull EditText studentNameEdittext, @NonNull TextView textView) {
    this.rootView = rootView;
    this.addFeesButton = addFeesButton;
    this.feesAmountEdittext = feesAmountEdittext;
    this.feesListview = feesListview;
    this.profilePicture = profilePicture;
    this.qrCodeImageview = qrCodeImageview;
    this.studentNameEdittext = studentNameEdittext;
    this.textView = textView;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHome4Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHome4Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_home4, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHome4Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.add_fees_button;
      Button addFeesButton = ViewBindings.findChildViewById(rootView, id);
      if (addFeesButton == null) {
        break missingId;
      }

      id = R.id.fees_amount_edittext;
      EditText feesAmountEdittext = ViewBindings.findChildViewById(rootView, id);
      if (feesAmountEdittext == null) {
        break missingId;
      }

      id = R.id.fees_listview;
      ListView feesListview = ViewBindings.findChildViewById(rootView, id);
      if (feesListview == null) {
        break missingId;
      }

      id = R.id.profile_picture;
      ImageView profilePicture = ViewBindings.findChildViewById(rootView, id);
      if (profilePicture == null) {
        break missingId;
      }

      id = R.id.qr_code_imageview;
      ImageView qrCodeImageview = ViewBindings.findChildViewById(rootView, id);
      if (qrCodeImageview == null) {
        break missingId;
      }

      id = R.id.student_name_edittext;
      EditText studentNameEdittext = ViewBindings.findChildViewById(rootView, id);
      if (studentNameEdittext == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      return new FragmentHome4Binding((LinearLayout) rootView, addFeesButton, feesAmountEdittext,
          feesListview, profilePicture, qrCodeImageview, studentNameEdittext, textView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
