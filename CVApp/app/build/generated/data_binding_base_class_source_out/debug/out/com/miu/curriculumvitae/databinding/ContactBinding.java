// Generated by view binder compiler. Do not edit!
package com.miu.curriculumvitae.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.miu.curriculumvitae.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ContactBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final LinearLayout gmail;

  @NonNull
  public final LinearLayout phone;

  @NonNull
  public final TextView txtPhone;

  private ContactBinding(@NonNull FrameLayout rootView, @NonNull LinearLayout gmail,
      @NonNull LinearLayout phone, @NonNull TextView txtPhone) {
    this.rootView = rootView;
    this.gmail = gmail;
    this.phone = phone;
    this.txtPhone = txtPhone;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ContactBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ContactBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.contact, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ContactBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.gmail;
      LinearLayout gmail = ViewBindings.findChildViewById(rootView, id);
      if (gmail == null) {
        break missingId;
      }

      id = R.id.phone;
      LinearLayout phone = ViewBindings.findChildViewById(rootView, id);
      if (phone == null) {
        break missingId;
      }

      id = R.id.txt_phone;
      TextView txtPhone = ViewBindings.findChildViewById(rootView, id);
      if (txtPhone == null) {
        break missingId;
      }

      return new ContactBinding((FrameLayout) rootView, gmail, phone, txtPhone);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
