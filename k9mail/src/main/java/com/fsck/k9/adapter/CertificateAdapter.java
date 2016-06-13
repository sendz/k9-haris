package com.fsck.k9.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.fsck.k9.R;
import com.fsck.k9.model.Certificate;

import java.util.ArrayList;

public class CertificateAdapter extends ArrayAdapter<Certificate> {
    public CertificateAdapter(Context context, ArrayList<Certificate> certificates) {
        super(context, 0, certificates);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Certificate certificate = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.certificate_list, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.line1);
        TextView desc = (TextView) convertView.findViewById(R.id.line2);

        name.setText(certificate.getName());
        desc.setText(certificate.getDescription());

        return convertView;
    }
}
