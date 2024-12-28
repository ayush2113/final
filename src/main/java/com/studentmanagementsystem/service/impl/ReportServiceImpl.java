package com.studentmanagementsystem.service.impl;

import com.studentmanagementsystem.entity.Report;
import com.studentmanagementsystem.entity.Student;
import com.studentmanagementsystem.repo.ReportRepository;
import com.studentmanagementsystem.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportRepository reportRepository;

    /*
    *
    * Report List by Pagination
    *
    * */
    @Override
    public List<Report> findAll(Pageable pageable) {
        return reportRepository.findAll(pageable).getContent();
    }

    /*
    *
    * Add New Report
    *
    * */
    @Override
    public Report save(Report report) {
        return reportRepository.save(report);
    }

    /*
    *
    * Report by I'd
    *
    * */
    @Override
    public Report findById(int id) {
        return reportRepository.findById(id);
    }

    /*
    *
    * Delete Report by I'd
    *
    * */
    @Override
    public Report deleteById(int id) {
        return reportRepository.deleteById(id);
    }

    /*
    *
    * Report by Date Created
    *
    * */
    @Override
    public List<Report> findByDateCreated(Date created) {
        return reportRepository.findByDateCreated(created);
    }

    /*
    *
    * Report by Content
    *
    * */
    @Override
    public List<Report> findByContentContaining(String content) {
        return reportRepository.findByContentContaining(content);
    }

    /*
    *
    * Report by Teacher Comment
    *
    * */
    @Override
    public List<Report> findByTeacherCommentContaining(String comment) {
        return reportRepository.findByTeacherCommentContaining(comment);
    }

    /*
    *
    * Find by Student Is
    *
    * */
    @Override
    public List<Report> findByStudent(Student student) {
        return reportRepository.findByStudent(student);
    }

    /*
    *
    * Add Dummy Data
    *
    * */
    public void init() {
        if (reportRepository.count() == 0) {
            for (int i = 1; i <= 100; i++) {
                Report report = new Report();

                report.setContent(new RandomNameGenerator().next(26, 100));

                report.setTeacherComment(new RandomNameGenerator().next(26, 100));

                report.setDateCreated(new Date());

                reportRepository.save(report);
            }
        }
    }

}
