package com.example.crudapi.ui.login;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import com.example.crudapi.R;
import com.example.crudapi.navigation.NavigationActivity;

public class LoginActivity extends AppCompatActivity {
    String login;
    protected Cursor cursor;
    private LoginViewModel loginViewModel;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private ProgressBar loadingProgressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );
        usernameEditText = findViewById( R.id.username );
        passwordEditText = findViewById( R.id.password );
        loginButton = findViewById( R.id.login );
        loadingProgressBar = findViewById( R.id.loading );

        loginButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent( LoginActivity.this, NavigationActivity.class );
                startActivity( inte );
            }
        } );


//        loginViewModel = new ViewModelProvider( this, new LoginViewModelFactory() )
//                .get( LoginViewModel.class );
//
//
//        loginViewModel.getLoginFormState().observe( this, new Observer<LoginFormState>() {
//            @Override
//            public void onChanged(@Nullable LoginFormState loginFormState) {
//                if (loginFormState == null) {
//                    return;
//                }
//                loginButton.setEnabled( loginFormState.isDataValid() );
//                if (loginFormState.getUsernameError() != null) {
//                    usernameEditText.setError( getString( loginFormState.getUsernameError() ) );
//                }
//                if (loginFormState.getPasswordError() != null) {
//                    passwordEditText.setError( getString( loginFormState.getPasswordError() ) );
//                }
//            }
//        } );
//
//        loginViewModel.getLoginResult().observe( this, new Observer<LoginResult>() {
//            @Override
//            public void onChanged(@Nullable LoginResult loginResult) {
//                if (loginResult == null) {
//                    return;
//                }
//                loadingProgressBar.setVisibility( View.GONE );
//                if (loginResult.getError() != null) {
//                    showLoginFailed( loginResult.getError() );
//                }
//                if (loginResult.getSuccess() != null) {
//                    updateUiWithUser( loginResult.getSuccess() );
//                }
//                setResult( Activity.RESULT_OK );
//
//                //Complete and destroy login activity once successful
//                finish();
//            }
//        } );
//
//        TextWatcher afterTextChangedListener = new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                // ignore
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                // ignore
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                loginViewModel.loginDataChanged( usernameEditText.getText().toString(),
//                        passwordEditText.getText().toString() );
//            }
//        };
//        usernameEditText.addTextChangedListener( afterTextChangedListener );
//        passwordEditText.addTextChangedListener( afterTextChangedListener );
//        passwordEditText.setOnEditorActionListener( new TextView.OnEditorActionListener() {
//
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if (actionId == EditorInfo.IME_ACTION_DONE) {
//                    loginViewModel.login( usernameEditText.getText().toString(),
//                            passwordEditText.getText().toString() );
//                }
//                return false;
//            }
//        } );
//
//        loginButton.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loadingProgressBar.setVisibility( View.VISIBLE );
//                loginViewModel.login( usernameEditText.getText().toString(),
//                        passwordEditText.getText().toString() );
//            }
//        } );
    }

    private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString( R.string.welcome ) + model.getDisplayName();
        // TODO : initiate successful logged in experience
        Toast.makeText( getApplicationContext(), welcome, Toast.LENGTH_LONG ).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText( getApplicationContext(), errorString, Toast.LENGTH_SHORT ).show();
    }
}