package com.org.acme.patient.onboarding.controller;

import com.org.acme.patient.onboarding.service.IOnboardingService;
import org.acme.patient.onboarding.model.Doctor;
import org.acme.patient.onboarding.model.Hospital;
import org.acme.patient.onboarding.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/onboarding")
public class OnboardingController{

    @Autowired
    IOnboardingService service;

    @PostMapping
    public Patient doOnboard(@RequestBody Patient patient){
        return null;
    }


    @PostMapping("/assignhospital/{zip}")
    public Mono <Hospital> assignHospitalToPatient(@PathVariable String zip) {
        return service.getParticipatingHospital(zip);
    }


    @PostMapping("/assigndoctor/{condition}")
    public Mono <Doctor> assignDoctorToPatient(@PathVariable String condition) {
        return service.getParticipatingDoctor(condition);
    }

    @PostMapping(value = "/notify/{contact}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void notifyPatient(@PathVariable String contact) {
        // do nothing here for demo...
        // irl would send email or text message or both
    }

}