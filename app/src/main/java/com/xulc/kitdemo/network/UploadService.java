package com.xulc.kitdemo.network;

import com.xulc.kitdemo.base.BaseResponse;
import com.xulc.kitdemo.bean.UploadImageData;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UploadService {
    @Multipart
    @POST("sn/mobileuploadimage")
    Observable<BaseResponse<UploadImageData>> uploadImage(@Part MultipartBody.Part part);//上传文件
}
