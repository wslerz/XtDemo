package com.xt.library.interfaces;

import android.content.Context;

import com.xt.library.beans.MqMessageBean;
import com.xt.library.interfaces.impl.XtSdkInterfaceImpl;
import com.zt.linphonelibrary.LinphoneUtils;

import java.util.List;


public class XtApiInterface {

    public final static XtSdkInterface app = new XtSdkInterfaceImpl();

    /**
     * 初始化接口
     *
     * @param application application
     * @param appToken    用户token
     */
    public static void init(Context application, String appToken, OnInfoEvents onEvents) {
        app.init(application, appToken, onEvents);
    }

    /**
     * 视频对讲
     *
     * @param elevEquipmentCode
     */
    public static void getVideoIntercom(Context context, String elevEquipmentCode, OnVideoIntercomEvents onVideoEvents) {
        app.getVideoIntercom(context, elevEquipmentCode, onVideoEvents);
    }
    /**
     * 视频对讲-设置扬声器
     * @param isSpeakerEnabled
     */
    public static void setSpeaker(boolean isSpeakerEnabled) {
        LinphoneUtils.toggleSpeaker(isSpeakerEnabled);
    }
    /**
     * 视频对讲-设置麦克风静音
     * @param isMicMuter
     */
    public static void setMicMuter(boolean isMicMuter) {
        LinphoneUtils.toggleMicro(isMicMuter);
    }
    /**
     * 视频对讲-挂断
     */
    public static void videoHangUp() {
        LinphoneUtils.hangUp();
    }
    /**
     * 视频监控
     *
     * @param elevEquipmentCode
     */
    public static void getVideoMonitoring(String elevEquipmentCode, OnVideoMonitoringEvents onVideoEvents) {
        app.getVideoMonitoring(elevEquipmentCode, onVideoEvents);
    }

    /**
     * 电梯运行状态
     *
     * @param elevEquipmentCode
     */
    public static void getElevatorStatus(String elevEquipmentCode, OnElevatorStatusEvents onVideoEvents) {
        app.getElevatorStatus(elevEquipmentCode, onVideoEvents);
    }

    /**
     * 初始化播放器
     */
//    public static void initJkplayer() {
//        VideoOptionModel videoOptionMode0l =new VideoOptionModel(1, "analyzemaxduration", 100);
//        VideoOptionModel videoOptionMode02 =new VideoOptionModel(1, "probesize", 10240);
//        VideoOptionModel videoOptionMode03 =new VideoOptionModel(1, "flush_packets", 1);
//        VideoOptionModel videoOptionMode04 =new VideoOptionModel(4, "packet-buffering", 0);
//        VideoOptionModel videoOptionMode05 =new VideoOptionModel(4, "framedrop", 1);
//        VideoOptionModel videoOptionMode06 =new VideoOptionModel(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "framedrop", 1);
//        VideoOptionModel videoOptionMode07 =new VideoOptionModel(IjkMediaPlayer.OPT_CATEGORY_FORMAT, "rtsp_transport", "tcp");
//        List list1 =new  java.util.ArrayList<VideoOptionModel>();
//        list1.add(videoOptionMode0l);
//        list1.add(videoOptionMode02);
//        list1.add(videoOptionMode03);
//        list1.add(videoOptionMode04);
//        list1.add(videoOptionMode05);
//        list1.add(videoOptionMode06);
//        list1.add(videoOptionMode07);
//        GSYVideoManager.instance().setOptionModelList(list1);
//    }
//    /**
//     * 释放播放器
//     */
//    public static void releaseAllVideos() {
//        GSYVideoPlayer.releaseAllVideos();
//    }

    public interface OnInfoEvents {
        //        void myInfoResult(MyInfoBean myInfoBean);
        void requestResult(String msg);
    }

    public interface OnVideoIntercomEvents {
        void videoIntercomResult(String url,String msg);//视频对讲回调
    }

    public interface OnVideoMonitoringEvents {
        void videoMonitoringResult(String url,String msg);//视频监控回调
    }

    public interface OnElevatorStatusEvents {
        void elevatorStatusResult(MqMessageBean elevatorInfo);//电梯运行状态
    }


}
