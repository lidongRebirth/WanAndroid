package com.myfittinglife.app.wanandroid.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author      LD
 * @Time        2019/1/21 19:22
 * @Describe    项目列表Bean(站内文章、站外文章，站外文章只是envelopePic为空而已)
 * @Modify
 */
public class ProjectListBean {
    /**
     * data : {"curPage":8,"datas":[{"apkLink":"http://www.wanandroid.com/blogimgs/538bddd9-eda7-4568-800c-2cd1bc77ab93.apk","author":"Kyson","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"Android开发者在性能检测方面的工具一直比较匮乏，仅有的一些工具，比如Android Device Monitor，使用起来也有些繁琐，使用起来对开发者有一定的要求。而线上的App监控更无从谈起。所以需要有一个系统能够提供Debug和Release阶段全方位的监控，更深入地了解对App运行时的状态。\r\n","envelopePic":"http://www.wanandroid.com/blogimgs/8483ff55-692b-4ac3-ae01-d7605b870d1f.png","fresh":false,"id":2233,"link":"http://www.wanandroid.com/blog/show/2026","niceDate":"2018-01-28","origin":"","projectLink":"https://github.com/Kyson/AndroidGodEye/","publishTime":1517149661000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"【开源完整项目】 AndroidGodEye 监控Android数据指标","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"http://www.wanandroid.com/blogimgs/e4d48142-8668-487d-8d37-83a6566555ba.apk","author":"Rayhahah","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"一款资讯类应用~~~o(*￣▽￣*)ブ，MVP+Retrofit+Rxjava\r\n","envelopePic":"http://www.wanandroid.com/blogimgs/b8ed8741-75f9-47a8-8148-0540644f3f83.jpg","fresh":false,"id":2232,"link":"http://www.wanandroid.com/blog/show/2024","niceDate":"2018-01-28","origin":"","projectLink":"https://github.com/Rayhahah/EasySports","publishTime":1517149531000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"【开源完整项目】仿虎扑应用EasySport","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"http://www.wanandroid.com/blogimgs/be28932a-5946-4eed-89ee-9d919ba7ec75.apk","author":"maoruibin","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"一个实现『划词翻译』功能的 Android 应用 ，可能是目前 Android 市场上翻译效率最高的一款应用。\r\n\r\n","envelopePic":"http://www.wanandroid.com/blogimgs/9249453d-0578-410f-8237-3c6e204c0c4b.gif","fresh":false,"id":2231,"link":"http://www.wanandroid.com/blog/show/2025","niceDate":"2018-01-28","origin":"","projectLink":"https://github.com/maoruibin/TranslateApp","publishTime":1517149256000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"【开源完整项目】咕咚翻译App","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"LRH1993","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"Google在今年的IO大会上宣布，将Kotlin作为Android开发的一级语言。作为紧跟潮流的弄潮儿，对kotlin稍做了解后，发现其有优秀的特性，所以就开始了学习，而Eyepetizer-in-Kotlin便是对kotlin进行学习后的阶段性成果。","envelopePic":"http://www.wanandroid.com/blogimgs/d8e91478-5f79-460b-8e39-42fc166b5519.png","fresh":false,"id":2230,"link":"http://www.wanandroid.com/blog/show/2028","niceDate":"2018-01-28","origin":"","projectLink":"https://github.com/LRH1993/Eyepetizer-in-Kotlin","publishTime":1517149004000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"【开源完整项目】开眼视频学习项目","type":0,"userId":-1,"visible":1,"zan":0}],"offset":105,"over":true,"pageCount":8,"size":15,"total":109}
     * errorCode : 0
     * errorMsg :
     */

    private DataBean data;
    private int errorCode;
    private String errorMsg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static class DataBean {
        /**
         * curPage : 8
         * datas : [{"apkLink":"http://www.wanandroid.com/blogimgs/538bddd9-eda7-4568-800c-2cd1bc77ab93.apk","author":"Kyson","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"Android开发者在性能检测方面的工具一直比较匮乏，仅有的一些工具，比如Android Device Monitor，使用起来也有些繁琐，使用起来对开发者有一定的要求。而线上的App监控更无从谈起。所以需要有一个系统能够提供Debug和Release阶段全方位的监控，更深入地了解对App运行时的状态。\r\n","envelopePic":"http://www.wanandroid.com/blogimgs/8483ff55-692b-4ac3-ae01-d7605b870d1f.png","fresh":false,"id":2233,"link":"http://www.wanandroid.com/blog/show/2026","niceDate":"2018-01-28","origin":"","projectLink":"https://github.com/Kyson/AndroidGodEye/","publishTime":1517149661000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"【开源完整项目】 AndroidGodEye 监控Android数据指标","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"http://www.wanandroid.com/blogimgs/e4d48142-8668-487d-8d37-83a6566555ba.apk","author":"Rayhahah","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"一款资讯类应用~~~o(*￣▽￣*)ブ，MVP+Retrofit+Rxjava\r\n","envelopePic":"http://www.wanandroid.com/blogimgs/b8ed8741-75f9-47a8-8148-0540644f3f83.jpg","fresh":false,"id":2232,"link":"http://www.wanandroid.com/blog/show/2024","niceDate":"2018-01-28","origin":"","projectLink":"https://github.com/Rayhahah/EasySports","publishTime":1517149531000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"【开源完整项目】仿虎扑应用EasySport","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"http://www.wanandroid.com/blogimgs/be28932a-5946-4eed-89ee-9d919ba7ec75.apk","author":"maoruibin","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"一个实现『划词翻译』功能的 Android 应用 ，可能是目前 Android 市场上翻译效率最高的一款应用。\r\n\r\n","envelopePic":"http://www.wanandroid.com/blogimgs/9249453d-0578-410f-8237-3c6e204c0c4b.gif","fresh":false,"id":2231,"link":"http://www.wanandroid.com/blog/show/2025","niceDate":"2018-01-28","origin":"","projectLink":"https://github.com/maoruibin/TranslateApp","publishTime":1517149256000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"【开源完整项目】咕咚翻译App","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"LRH1993","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"Google在今年的IO大会上宣布，将Kotlin作为Android开发的一级语言。作为紧跟潮流的弄潮儿，对kotlin稍做了解后，发现其有优秀的特性，所以就开始了学习，而Eyepetizer-in-Kotlin便是对kotlin进行学习后的阶段性成果。","envelopePic":"http://www.wanandroid.com/blogimgs/d8e91478-5f79-460b-8e39-42fc166b5519.png","fresh":false,"id":2230,"link":"http://www.wanandroid.com/blog/show/2028","niceDate":"2018-01-28","origin":"","projectLink":"https://github.com/LRH1993/Eyepetizer-in-Kotlin","publishTime":1517149004000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"【开源完整项目】开眼视频学习项目","type":0,"userId":-1,"visible":1,"zan":0}]
         * offset : 105
         * over : true
         * pageCount : 8
         * size : 15
         * total : 109
         */

        private int curPage;
        private int offset;
        private boolean over;
        private int pageCount;
        private int size;
        private int total;
        private List<DatasBean> datas;

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public boolean isOver() {
            return over;
        }

        public void setOver(boolean over) {
            this.over = over;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<DatasBean> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        public static class DatasBean implements Parcelable {
            /**
             * apkLink : http://www.wanandroid.com/blogimgs/538bddd9-eda7-4568-800c-2cd1bc77ab93.apk
             * author : Kyson
             * chapterId : 294
             * chapterName : 完整项目
             * collect : false
             * courseId : 13
             * desc : Android开发者在性能检测方面的工具一直比较匮乏，仅有的一些工具，比如Android Device Monitor，使用起来也有些繁琐，使用起来对开发者有一定的要求。而线上的App监控更无从谈起。所以需要有一个系统能够提供Debug和Release阶段全方位的监控，更深入地了解对App运行时的状态。
             * <p>
             * envelopePic : http://www.wanandroid.com/blogimgs/8483ff55-692b-4ac3-ae01-d7605b870d1f.png
             * fresh : false
             * id : 2233
             * link : http://www.wanandroid.com/blog/show/2026
             * niceDate : 2018-01-28
             * origin :
             * projectLink : https://github.com/Kyson/AndroidGodEye/
             * publishTime : 1517149661000
             * superChapterId : 294
             * superChapterName : 开源项目主Tab
             * tags : [{"name":"项目","url":"/project/list/1?cid=294"}]
             * title : 【开源完整项目】 AndroidGodEye 监控Android数据指标
             * type : 0
             * userId : -1
             * visible : 1
             * zan : 0
             */

            private String apkLink;
            private String author;
            private int chapterId;
            private String chapterName;
            private boolean collect;
            private int courseId;
            private String desc;
            private String envelopePic;
            private boolean fresh;
            private int id;
            private String link;
            private String niceDate;
            private String origin;
            private String projectLink;
            private long publishTime;
            private int superChapterId;
            private String superChapterName;
            private String title;
            private int type;
            private int userId;
            private int visible;
            private int zan;
            private List<TagsBean> tags;


            public String getApkLink() {
                return apkLink;
            }

            public void setApkLink(String apkLink) {
                this.apkLink = apkLink;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public int getChapterId() {
                return chapterId;
            }

            public void setChapterId(int chapterId) {
                this.chapterId = chapterId;
            }

            public String getChapterName() {
                return chapterName;
            }

            public void setChapterName(String chapterName) {
                this.chapterName = chapterName;
            }

            public boolean isCollect() {
                return collect;
            }

            public void setCollect(boolean collect) {
                this.collect = collect;
            }

            public int getCourseId() {
                return courseId;
            }

            public void setCourseId(int courseId) {
                this.courseId = courseId;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getEnvelopePic() {
                return envelopePic;
            }

            public void setEnvelopePic(String envelopePic) {
                this.envelopePic = envelopePic;
            }

            public boolean isFresh() {
                return fresh;
            }

            public void setFresh(boolean fresh) {
                this.fresh = fresh;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getNiceDate() {
                return niceDate;
            }

            public void setNiceDate(String niceDate) {
                this.niceDate = niceDate;
            }

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }

            public String getProjectLink() {
                return projectLink;
            }

            public void setProjectLink(String projectLink) {
                this.projectLink = projectLink;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public int getSuperChapterId() {
                return superChapterId;
            }

            public void setSuperChapterId(int superChapterId) {
                this.superChapterId = superChapterId;
            }

            public String getSuperChapterName() {
                return superChapterName;
            }

            public void setSuperChapterName(String superChapterName) {
                this.superChapterName = superChapterName;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getVisible() {
                return visible;
            }

            public void setVisible(int visible) {
                this.visible = visible;
            }

            public int getZan() {
                return zan;
            }

            public void setZan(int zan) {
                this.zan = zan;
            }

            public List<TagsBean> getTags() {
                return tags;
            }
            public void setTags(List<TagsBean> tags) {
                this.tags = tags;
            }
            public static class TagsBean implements Parcelable {
                /**
                 * name : 项目
                 * url : /project/list/1?cid=294
                 */

                private String name;
                private String url;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.name);
                    dest.writeString(this.url);
                }

                public TagsBean() {
                }

                protected TagsBean(Parcel in) {
                    this.name = in.readString();
                    this.url = in.readString();
                }

                public static final Creator<TagsBean> CREATOR = new Creator<TagsBean>() {
                    @Override
                    public TagsBean createFromParcel(Parcel source) {
                        return new TagsBean(source);
                    }

                    @Override
                    public TagsBean[] newArray(int size) {
                        return new TagsBean[size];
                    }
                };
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.apkLink);
                dest.writeString(this.author);
                dest.writeInt(this.chapterId);
                dest.writeString(this.chapterName);
                dest.writeByte(this.collect ? (byte) 1 : (byte) 0);
                dest.writeInt(this.courseId);
                dest.writeString(this.desc);
                dest.writeString(this.envelopePic);
                dest.writeByte(this.fresh ? (byte) 1 : (byte) 0);
                dest.writeInt(this.id);
                dest.writeString(this.link);
                dest.writeString(this.niceDate);
                dest.writeString(this.origin);
                dest.writeString(this.projectLink);
                dest.writeLong(this.publishTime);
                dest.writeInt(this.superChapterId);
                dest.writeString(this.superChapterName);
                dest.writeString(this.title);
                dest.writeInt(this.type);
                dest.writeInt(this.userId);
                dest.writeInt(this.visible);
                dest.writeInt(this.zan);
                dest.writeList(this.tags);
            }

            public DatasBean() {
            }

            protected DatasBean(Parcel in) {
                this.apkLink = in.readString();
                this.author = in.readString();
                this.chapterId = in.readInt();
                this.chapterName = in.readString();
                this.collect = in.readByte() != 0;
                this.courseId = in.readInt();
                this.desc = in.readString();
                this.envelopePic = in.readString();
                this.fresh = in.readByte() != 0;
                this.id = in.readInt();
                this.link = in.readString();
                this.niceDate = in.readString();
                this.origin = in.readString();
                this.projectLink = in.readString();
                this.publishTime = in.readLong();
                this.superChapterId = in.readInt();
                this.superChapterName = in.readString();
                this.title = in.readString();
                this.type = in.readInt();
                this.userId = in.readInt();
                this.visible = in.readInt();
                this.zan = in.readInt();
                this.tags = new ArrayList<TagsBean>();
                in.readList(this.tags, TagsBean.class.getClassLoader());
            }

            public static final Parcelable.Creator<DatasBean> CREATOR = new Parcelable.Creator<DatasBean>() {
                @Override
                public DatasBean createFromParcel(Parcel source) {
                    return new DatasBean(source);
                }

                @Override
                public DatasBean[] newArray(int size) {
                    return new DatasBean[size];
                }
            };
        }
    }
}
