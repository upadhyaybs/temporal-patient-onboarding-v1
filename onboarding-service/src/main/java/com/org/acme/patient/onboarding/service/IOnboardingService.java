package com.org.acme.patient.onboarding.service;

import org.acme.patient.onboarding.model.Doctor;
import org.acme.patient.onboarding.model.Hospital;
import reactor.core.publisher.Mono;



public interface IOnboardingService {

  Mono<Hospital> getParticipatingHospital(String zip);

  Mono<Doctor> getParticipatingDoctor(String condition);
}