package com.example.rhythmpiano;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.rhythmpiano.fragment.HomeFragment;
import com.example.rhythmpiano.fragment.ProfileFragment;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;

//곡 선택하는 화면
public class MainActivity extends AppCompatActivity{

    private FragmentManager mFragmentManager = getSupportFragmentManager();
    private HomeFragment mHomeFragment = new HomeFragment();
    private ProfileFragment mProfileFragment = new ProfileFragment();
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setItemIconTintList(null);
        bottomNavigation.setOnNavigationItemSelectedListener(new ItemSelectedListener());

        //초기화면 설정
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.main_frame_layout, mHomeFragment).commitAllowingStateLoss();
    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction = mFragmentManager.beginTransaction();

            switch(menuItem.getItemId())
            {
                case R.id.homePage:
                    transaction.replace(R.id.main_frame_layout, mHomeFragment).commitAllowingStateLoss();
                    break;
                case R.id.profilePage:
                    transaction.replace(R.id.main_frame_layout, mProfileFragment).commitAllowingStateLoss();
                    break;
            }
            return true;
        }
    }
}
