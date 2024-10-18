package com.juggle.im.shadow.methods.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.juggle.im.JuggleIm;
import com.juggle.im.models.ResponseResult;
import com.juggle.im.models.user.UserTag;
import com.juggle.im.models.user.UserTags;
import com.juggle.im.models.user.UserTagsResult;

import io.rong.models.response.GetTagResult;
import io.rong.models.user.BatchTagModel;
import io.rong.models.user.GetTagModel;
import io.rong.models.user.TagModel;

public class RcTag {
    private JuggleIm juggleim;

    public RcTag(JuggleIm juggleim){
        this.juggleim = juggleim;
    }

    public io.rong.models.Result set(TagModel rcTag)throws Exception{
        UserTag tag = new UserTag();
        tag.setUserId(rcTag.getUserId());
        List<String> tags = new ArrayList<>();
        for(String t : rcTag.getTags()){
            tags.add(t);
        }
        tag.setTags(tags);
        UserTags uTags = new UserTags();
        List<UserTag> list = new ArrayList<>();
        list.add(tag);
        uTags.setUserTags(list);
        ResponseResult result = this.juggleim.user.tagUser.add(uTags);
        io.rong.models.response.ResponseResult rcResult;
        if(result!=null){
            rcResult = new io.rong.models.response.ResponseResult(result.getCode(), result.getErrorMessage());
        }else{
            rcResult = new io.rong.models.response.ResponseResult(500, "can not get data.");
        }
        return rcResult;
    }

    public io.rong.models.Result batchSet(BatchTagModel batchTag)throws Exception{
        List<UserTag> list = new ArrayList<>();
        for(String userId : batchTag.getUserIds()){
            UserTag tag = new UserTag();
            tag.setUserId(userId);
            List<String> tags = new ArrayList<>();
            for(String t : batchTag.getTags()){
                tags.add(t);
            }
            tag.setTags(tags);
            list.add(tag);
        }
        UserTags uTags = new UserTags();
        uTags.setUserTags(list);
        ResponseResult result = this.juggleim.user.tagUser.add(uTags);
        io.rong.models.response.ResponseResult rcResult;
        if(result!=null){
            rcResult = new io.rong.models.response.ResponseResult(result.getCode(), result.getErrorMessage());
        }else{
            rcResult = new io.rong.models.response.ResponseResult(500, "can not get data.");
        }
        return rcResult;
    }

    public GetTagResult get(GetTagModel getTag)throws Exception{
        UserTagsResult result = this.juggleim.user.tagUser.qryUserTags(getTag.getUserIds());
        GetTagResult rcResult;
        if(result!=null){
            if(result.getUserTags()!=null){
                Map<String,List<String>> map = new HashMap<String,List<String>>();
                for(UserTag t : result.getUserTags().getUserTags()){
                    map.put(t.getUserId(), t.getTags());
                }
                rcResult = new GetTagResult();
                rcResult.setResult(map);
            }else{
                rcResult = new GetTagResult();
                rcResult.setCode(result.getCode());
                rcResult.setErrorMessage(result.getErrorMessage());
            }
        }else{
            rcResult = new GetTagResult();
            rcResult.setCode(500);
            rcResult.setErrorMessage("can not get data");
        }
        return rcResult;
    }
}
