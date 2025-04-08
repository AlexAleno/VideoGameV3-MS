package com.champsoft.usermanagement.BusinessLogic;

import com.example.videogamev3.UserManagement.DataAccess.Admin;
import com.example.videogamev3.UserManagement.DataAccess.AdminRepository;
import com.example.videogamev3.UserManagement.DataMapper.AdminRequestMapper;
import com.example.videogamev3.UserManagement.DataMapper.AdminResponseMapper;
import com.example.videogamev3.UserManagement.Presentation.AdminRequestModel;
import com.example.videogamev3.UserManagement.Presentation.AdminResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminRepository adminRepository;
    private final AdminResponseMapper adminResponseMapper;
    private final AdminRequestMapper adminRequestMapper;

    public AdminService(AdminRepository adminRepository, AdminResponseMapper adminResponseMapper, AdminRequestMapper adminRequestMapper) {
        this.adminRepository = adminRepository;
        this.adminResponseMapper = adminResponseMapper;
        this.adminRequestMapper = adminRequestMapper;
    }

    public List<AdminResponseModel> getAllAdmins() {
        List<Admin> admins = adminRepository.findAll();
        return adminResponseMapper.adminToAdminResponseModel(admins);
    }

    public AdminResponseModel getAdminById(String uuid) {
        Admin admin = adminRepository.findAdminByAdminId_uuid(uuid);
        return adminResponseMapper.adminToAdminResponseModel(admin);
    }

    public AdminResponseModel addAdmin(AdminRequestModel adminRequestModel) {
        Admin admin = adminRequestMapper.adminRequestModelToAdmin(adminRequestModel);
        adminRepository.save(admin);
        return adminResponseMapper.adminToAdminResponseModel(admin);
    }

    public AdminResponseModel updateAdmin(AdminRequestModel adminRequestModel, String uuid) {
        Admin admin = adminRepository.findAdminByAdminId_uuid(uuid);
        admin.setUsername(adminRequestModel.getUsername());
        admin.setPassword(adminRequestModel.getPassword());
        adminRepository.save(admin);
        return adminResponseMapper.adminToAdminResponseModel(admin);
    }

    public void deleteAdmin(String uuid) {
        Admin admin = adminRepository.findAdminByAdminId_uuid(uuid);
        adminRepository.delete(admin);
    }
}
