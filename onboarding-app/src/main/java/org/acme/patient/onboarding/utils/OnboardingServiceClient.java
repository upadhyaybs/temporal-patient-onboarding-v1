package org.acme.patient.onboarding.utils;

import org.acme.patient.onboarding.model.Doctor;
import org.acme.patient.onboarding.model.Hospital;
import org.acme.patient.onboarding.model.Patient;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/onboarding")
@RegisterRestClient
public interface OnboardingServiceClient {

    @POST
    @Path("/assignhospital/{zip}")
    Hospital assignHospitalToPatient(@PathParam("zip") String zip);

    @POST
    @Path("/assigndoctor/{condition}")
    Doctor assignDoctorToPatient(@PathParam("condition") String condition);

    @POST
    @Path("/notify/{email}")
    Patient notifyPatient(@PathParam("email") String email);
}
