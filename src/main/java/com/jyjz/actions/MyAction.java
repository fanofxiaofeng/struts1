package com.jyjz.actions;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class MyAction extends Action {
    private static final String CONDITION_TRUE_TRUE = "case11";
    private static final String CONDITION_TRUE_FALSE = "case10";
    private static final String CONDITION_FALSE_TRUE = "case01";
    private static final String CONDITION_FALSE_FALSE = "case00";

    @Override
    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {

        Map<String, String> map = new HashMap<String, String>();
        String v1 = request.getParameter("k1");
        String v2 = request.getParameter("k2");

        // 判定 k1 是否存在
        boolean judge1 = v1 != null;

        // 判定 k2 是否存在
        boolean judge2 = v2 != null;

        if (judge1) {
            map.put("k1", v1);
        }
        if (judge2) {
            map.put("k2", v2);
        }
        request.setAttribute("dict", map);
        System.out.println(map.toString());
        if (judge1 && judge2) {
            // k1 存在, k2 存在
            return mapping.findForward(CONDITION_TRUE_TRUE);
        } else if (judge1) {
            // k1 存在, k2不存在
            return mapping.findForward(CONDITION_TRUE_FALSE);
        } else if (judge2) {
            // k1 不存在, k2 存在
            return mapping.findForward(CONDITION_FALSE_TRUE);
        } else {
            // k1 不存在, k2 不存在
            return mapping.findForward(CONDITION_FALSE_FALSE);
        }
    }
}
