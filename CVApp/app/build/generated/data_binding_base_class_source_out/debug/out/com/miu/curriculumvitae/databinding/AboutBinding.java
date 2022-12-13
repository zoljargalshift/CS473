// Generated by view binder compiler. Do not edit!
package com.miu.curriculumvitae.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.miu.curriculumvitae.R;
import com.miu.curriculumvitae.common.FlowLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class AboutBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final FlowLayout certificates;

  @NonNull
  public final LinearLayout educations;

  private AboutBinding(@NonNull ScrollView rootView, @NonNull FlowLayout certificates,
      @NonNull LinearLayout educations) {
    this.rootView = rootView;
    this.certificates = certificates;
    this.educations = educations;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static AboutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AboutBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.about, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AboutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.certificates;
      FlowLayout certificates = ViewBindings.findChildViewById(rootView, id);
      if (certificates == null) {
        break missingId;
      }

      id = R.id.educations;
      LinearLayout educations = ViewBindings.findChildViewById(rootView, id);
      if (educations == null) {
        break missingId;
      }

      return new AboutBinding((ScrollView) rootView, certificates, educations);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
