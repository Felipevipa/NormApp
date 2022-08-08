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

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class PingFragment extends Fragment {

    private FragmentPingBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PingViewModel pingViewModel =
                new ViewModelProvider(this).get(PingViewModel.class);

        binding = FragmentPingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // final TextView textView = binding.textPing;
        // pingViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        EditText IpField = (EditText) root.findViewById(R.id.IpField);
        Button pingSubmitButton = (Button) root.findViewById(R.id.pingSubmitButton);
        TextView IPLabel = (TextView) root.findViewById(R.id.IPLabel);
        TextView ErrorLabel = (TextView) root.findViewById(R.id.ErrorLabel);


        pingSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(IpField.getText().toString());
                System.out.println("Executing function");
                String ipAddress = IpField.getText().toString();
                IPLabel.setText("IP " + ipAddress);
                //String ipAddress = "127.0.0.1";
                try {
                    ErrorLabel.setText("Pinging");
                    boolean answer = sendPingRequest(ipAddress);
                    ErrorLabel.setText(String.valueOf(answer));
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

            /*private void sendPingRequest(String ipAddress)
                throws UnknownHostException, IOException, Exception
            {
                InetAddress geek = InetAddress.getByName(ipAddress);
                System.out.println("Sending Ping Request to " + ipAddress);
                if (geek.isReachable(10000)){
                    System.out.println("Host is reachable");
                } else {
                    System.out.println("Sorry ! We can't reach to this host");
                    throw new Exception("Exception message");
                }
            }*/
            private boolean sendPingRequest(String ipAddress)
                    throws UnknownHostException, IOException, Exception
            {
                Process p1 = Runtime.getRuntime().exec("/system/bin/ping -c 1 " + ipAddress);
                int returnval = p1.waitFor();
                System.out.println(returnval);
                System.out.println(returnval==0);
                return returnval==0;
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