package com.example.xyblog.Controller.admin;

import com.example.xyblog.Bean.FriendLink;
import com.example.xyblog.Bean.Type;
import com.example.xyblog.Service.FriendLinkService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class FriendLinkController {
    @Autowired
    private FriendLinkService friendLinkService;

    @GetMapping("/friendlinks")
    public String listFriendLink(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, Model model) {
        List<FriendLink> friendLinks = friendLinkService.getFriendLinks();
        PageHelper.startPage(pageNum, 10);
        PageInfo<FriendLink> pageInfo = new PageInfo<>(friendLinks);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/friendlinks";
    }

    // 友链编辑页面
    @GetMapping("/friendlinks/input")
    public String newType(Model model) {
        model.addAttribute("friendlink", new FriendLink());
        return "admin/friendlinks-input";
    }

    // 保存新增
    @PostMapping("/friendlinks")
    public String saveFriendLink(@Valid FriendLink friendLink, RedirectAttributes attributes) {
        FriendLink res = friendLinkService.getFriendLinkByAddress(friendLink.getLinkAddress());
        if (res != null) {
            attributes.addFlashAttribute("message", "友链重复，已经添加该朋友哟");
            return "redirect:/admin/friendlinks/input";
        }
        int num = friendLinkService.saveFriendLink(friendLink);
        attributes.addFlashAttribute("message", num == 0 ? "添加失败" : "添加成功");
        return "redirect:/admin/friendlinks";
    }

    // 编辑友链
    @GetMapping("/friendlinks/{id}/input")
    public String editFriendLink(@PathVariable Long id, Model model) {
        model.addAttribute("friendlink",friendLinkService.getFriendLinkById(id));
        return "admin/friendlinks-input";
    }

    // 保存编辑
    @PostMapping("/friendlinks/{id}")
    public String updateFriendLink(@Valid FriendLink friendLink, RedirectAttributes attributes) {
        attributes.addFlashAttribute("message", friendLinkService.updateFriendLink(friendLink) == 0 ? "更改成功" : "更改失败");
        return "redirect:/admin/friendlinks";
    }

    // 删除友链
    @GetMapping("/friendlinks/{id}/delete")
    public String deleteFriendLink(@PathVariable Long id, RedirectAttributes attributes) {
        friendLinkService.deleteFriendLink(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/friendlinks";
    }

}
