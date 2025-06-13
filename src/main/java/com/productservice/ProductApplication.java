package com.productservice;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.productservice.inheritancetypes.join.TA;
import com.productservice.inheritancetypes.join.TARepository;
import com.productservice.inheritancetypes.mappedsource.Student;
import com.productservice.inheritancetypes.mappedsource.StudentRepository;
import com.productservice.inheritancetypes.singleclass.UserRepository;
import com.productservice.inheritancetypes.tableperclass.Instructor;
import com.productservice.inheritancetypes.tableperclass.InstructorRepository;

@SpringBootApplication
public class ProductApplication implements CommandLineRunner{
	
	private StudentRepository studentRepo;
	
	private InstructorRepository instRepo;
	
	private TARepository taRepository;
	
	private UserRepository userRepo;

    public ProductApplication(StudentRepository studentRepo, @Qualifier("tpc_instructor_repository")InstructorRepository instRepo,
    	@Qualifier("j_ta_repository")TARepository taRepository,
    	UserRepository userRepo) {
		this.studentRepo = studentRepo;
		this.instRepo = instRepo;
		this.taRepository = taRepository;
		this.userRepo = userRepo;
	}

	public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
        
    }

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Student student = new Student();
        student.setEmail("chaitanya@gmail.com");
        student.setAttendance(89.09);
        student.setName("Chaitanya");
        student.setPsp(85);
        
        Instructor inst = new Instructor();
        inst.setEmail("inst@gmail.com");
        inst.setName("chaitanya");
        inst.setNoOfBatches(10);
        
        studentRepo.save(student);
        instRepo.save(inst);
        
        TA ta= new TA();
        ta.setName("riaz");
        ta.setDoubtsClarified(100);
        ta.setSessionStartTime(LocalDateTime.now());
        ta.setEmail("test@gmail.com");
        taRepository.save(ta);
		
        com.productservice.inheritancetypes.singleclass.Instructor instr = new com.productservice.inheritancetypes.singleclass.Instructor();
        instr.setEmail("test@asjsdh.com");
        instr.setName("rihaan");
        instr.setNoOfBatches(9);
        
        userRepo.save(instr);
        
	}

}
