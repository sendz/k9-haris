package com.fsck.k9.activity;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.fsck.k9.R;
import com.fsck.k9.adapter.CertificateAdapter;
import com.fsck.k9.model.Certificate;

import java.util.ArrayList;

public class Certificates extends K9ListActivity {

    private CertificateAdapter adapter;
    private ArrayList<Certificate> arrayList;
    private ListView listView;

    private ActionBar actionBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.certificate);
        listView = (ListView) findViewById(android.R.id.list);
        actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        arrayList = new ArrayList<>();
        adapter = new CertificateAdapter(this, arrayList);

        listView.setAdapter(adapter);

        ArrayList<Certificate> newCertificate = new ArrayList<>();

        newCertificate.add(new Certificate("Certificate 1", "Description 1"));
        newCertificate.add(new Certificate("Certificate 2", "Description 2"));
        newCertificate.add(new Certificate("Certificate 3", "Description 3"));

        adapter.addAll(newCertificate);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }
}
