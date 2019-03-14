package com.myfittinglife.app.wanandroid;

import com.myfittinglife.app.wanandroid.bean.MyCollectionBean2;
import com.myfittinglife.app.wanandroid.bean.UserBean;
import com.myfittinglife.app.wanandroid.bean.ProjectClassifyBean;
import com.myfittinglife.app.wanandroid.bean.ProjectListBean;
import com.myfittinglife.app.wanandroid.bean.RegisterBean;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * @Author
 * @Time        2019/1/21 17:37
 * @Describe    所有网络访问的接口编写
 * @Modify
 */
public interface Api {

    //*---------------------------------------------------------------------------------------------
    /**
     * 通用测试的方法(待测试)
     * @return
     */
    @GET("{url}")
    Call<ResponseBody> getCommentData(@Path("url") String url,@QueryMap Map<String, String> params);

    //*---------------------------------------------------------------------------------------------

    /**
     * 注册(已完成)
     */
    @POST("user/register")
    Call<RegisterBean> registerAccount(@QueryMap Map<String, String> params);



    /**
     * 登录
     */
    @POST("user/login")
    Call<UserBean> login(@QueryMap Map <String,String> params);





    /**
     * 获取项目分类名称
     */
    @GET("project/tree/json")
    Call<ProjectClassifyBean> getProjectClassify();

    /**
     * 获取项目列表信息
     */
//    @Headers({"username:836354552","password:123456"})
    @GET("project/list/{url}/json")
    Call<ProjectListBean> getProjectList(@Path("url")int i, @Query("cid")int cid);



    /**
     * 收藏站内文章
     */
    @POST("lg/collect/{id}/json")
    Call<ResponseBody> collectInSiteEssay(@Path("id")int id);


    /**
     * 取消收藏（文章列表处）
     */
    @POST("lg/uncollect_originId/{id}/json")
    Call<ResponseBody> unCollectInSiteEssay(@Path("id")int id);


    /**
     * 取消收藏（我的收藏处）
     */
    @POST("lg/uncollect/{id}/json")
    Call<ResponseBody> unCollectMyEssay(@Path("id") int id,@Query("originId")int originId);


    /**
     * 收藏站外文章（公众号的文章）
     */


    /**
     * 我的收藏
     */
    @GET("lg/collect/list/{page}/json")
    Call<MyCollectionBean2> getMyCollection(@Path("page")   int page);



}
