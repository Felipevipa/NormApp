package com.normapp.ui.ping;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.normapp.R;
import com.normapp.databinding.FragmentPingBinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class PingFragment extends Fragment {

    private FragmentPingBinding binding;

    private Runnable separateThread = new Runnable() {
        @Override
        public void run() {
            try {
                textOutputPing.setText("");
            } catch (Exception e) {
                System.out.println("error");
            }
            System.out.println(IpField.getText().toString());
            System.out.println("Executing function");
            String ipAddress = IpField.getText().toString();
            IPLabel.setText("IP " + ipAddress);
            //String ipAddress = "127.0.0.1";
            try {
                ErrorLabel.setText("Pinging");
                boolean answer = sendPingRequest(ipAddress);
                if (answer) {
                    ErrorLabel.setText("Conexion Exitosa");
                } else {
                    ErrorLabel.setText("Destino no alcanzable");
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("IOException");
                ErrorLabel.setText("IOException");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Exception");
                ErrorLabel.setText("Exception");
            }
        }
    };

    private boolean sendPingRequest(String ipAddress)
            throws UnknownHostException, IOException, Exception
    {
        long start = System.currentTimeMillis();
        Process p1 = Runtime.getRuntime().exec("/system/bin/ping -c 4 " + ipAddress);

        BufferedReader buffy = new BufferedReader(new InputStreamReader(p1.getInputStream()));
        String readline;
        long ping = 0;
        while ((readline = buffy.readLine()) != null) {
            System.out.println(readline);
            if (readline.contains("reply")) {
                ping = System.currentTimeMillis();
                System.out.println("pinged in: " + ping);
            }
            textOutputPing.setText(textOutputPing.getText().toString() + '\n' + readline);
        }
        long end = System.currentTimeMillis();
        String done = "Completed in times: " + start + ping + end;
        System.out.println(done);
        int returnval = p1.waitFor();
        System.out.println(returnval);
        System.out.println(returnval==0);
        return returnval==0;
    }

    private TextView textOutputPing;
    private TextView IPLabel;
    private TextView ErrorLabel;
    private EditText IpField;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PingViewModel pingViewModel =
                new ViewModelProvider(this).get(PingViewModel.class);

        binding = FragmentPingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // final TextView textView = binding.textPing;
        // pingViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        IpField = (EditText) root.findViewById(R.id.IpField);
        Button pingSubmitButton = (Button) root.findViewById(R.id.pingSubmitButton);
        IPLabel = (TextView) root.findViewById(R.id.IPLabel);
        ErrorLabel = (TextView) root.findViewById(R.id.ErrorLabel);
        textOutputPing = (TextView) root.findViewById(R.id.textOutputPing);


        pingSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread t = new Thread(separateThread);
                t.start();
            }


        });



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}