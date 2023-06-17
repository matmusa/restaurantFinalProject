package peaksoft.service;

import peaksoft.dto.request.SignInRequest;
import peaksoft.dto.request.SignUpRequest;
import peaksoft.dto.response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse signUp(SignUpRequest signUpRequest);

    AuthenticationResponse signIn(SignInRequest signInRequest);
}
