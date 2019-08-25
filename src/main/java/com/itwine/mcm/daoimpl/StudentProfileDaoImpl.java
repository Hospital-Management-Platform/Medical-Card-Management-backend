package com.itwine.mcm.daoimpl;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwine.mcm.dao.StudentProfileDao;
import com.itwine.mcm.model.StudentProfile;

public class StudentProfileDaoImpl implements StudentProfileDao{

	
	@Autowired
	SessionFactory sessionFactory;
	
	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addStudent(StudentProfile studentProfile) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(studentProfile);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public StudentProfile getStudentById(long id) throws Exception {
		session = sessionFactory.openSession();
		StudentProfile studentProfile = (StudentProfile) session.load(StudentProfile.class, id);
		tx= session.getTransaction();
		session.beginTransaction();
		tx.commit();
		session.close();
		return studentProfile;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<StudentProfile> getStudentProfileByList() throws Exception {
		session = sessionFactory.openSession();
		tx= session.beginTransaction();
		List<StudentProfile> studentList = session.createCriteria(StudentProfile.class).list();
		tx.commit();
		session.close();
		return studentList;
	}
	
	@Override
	public boolean deleteStudentById(long id) throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(StudentProfile.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return true;
	}
	
	@Override
	public boolean updateStudent(StudentProfile studentProfile, long id) throws Exception{
		session= sessionFactory.openSession();
		StudentProfile studentProfile1 = (StudentProfile) session.load(StudentProfile.class, id);
		studentProfile1.setStdName(studentProfile.getStdName());
		studentProfile1.setAddressOne(studentProfile.getAddressOne());
		studentProfile1.setAddressTwo(studentProfile.getAddressTwo());
		studentProfile1.setCity(studentProfile.getCity());
		studentProfile1.setState(studentProfile.getState());
		studentProfile1.setCountryName(studentProfile.getCountryName());
		studentProfile1.setZipcode(studentProfile.getZipcode());
		studentProfile1.setStdPhone(studentProfile.getStdPhone());
		studentProfile1.setGender(studentProfile.getGender());
		studentProfile1.setStdEmail(studentProfile.getStdEmail());
		studentProfile1.setParentPhone(studentProfile.getParentPhone());
		studentProfile1.setInstitutionName(studentProfile.getInstitutionName());
		studentProfile1.setStdAdmissionNumber(studentProfile.getStdAdmissionNumber());
		studentProfile1.setStdPassword(studentProfile.getStdPassword());
		studentProfile1.setPlan(studentProfile.getPlan());
		studentProfile1.setCourseCategory(studentProfile.getCourseCategory());
		studentProfile1.setStatus(studentProfile.getStatus());
		/*studentProfile1.setStdImage(studentProfile.getStdImage());
		studentProfile1.setStdImageData(studentProfile.getStdImageData());*/
		studentProfile1.setYearofjoining(studentProfile.getYearofjoining());
		tx= session.getTransaction();
		session.beginTransaction();
		session.update(studentProfile1);
		tx.commit();
		session.close();
		return true;
		
	}

}
