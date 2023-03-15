package com.example.xyblog.Controller.admin;

import com.example.xyblog.Bean.Type;
import com.example.xyblog.Service.TypeService;
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
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String listTypes(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<Type> types = typeService.listTypes();

        if (types != null) {
            PageInfo<Type> pageInfo = new PageInfo<>(types);
            model.addAttribute("pageInfo", pageInfo);
        }
        return "admin/types";
    }

    // 新增分类页面
    @GetMapping("/types/input")
    public String typesInput(Model model) {
        model.addAttribute("type", new Type());
        return "admin/types-input";
    }

    // 保存分类
    @PostMapping("/types")
    public String saveType(@Valid Type type, RedirectAttributes attributes) {
        Type type1 = typeService.getTypeByName(type.getName());
        if (type1 != null) {
            attributes.addFlashAttribute("message", "不能添加重复分类");
            return "redirect:/admin/types/input";
        }
        int res = typeService.saveType(type);
        if (res == 0) {
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/admin/types";
    }

    // 编辑分类
    @GetMapping("types/{id}/input")
    public String editType(@PathVariable Long id, Model model) {
        model.addAttribute("type", typeService.getType(id));
        return "admin/types-input";
    }

    // 保存编辑
    @PostMapping("/types/{id}")
    public String updateType(@Valid Type type, RedirectAttributes attributes) {
        int res = typeService.updateType(type);
        if (res == 0) {
            attributes.addFlashAttribute("message", "编辑失败");
        } else {
            attributes.addFlashAttribute("message", "编辑成功");
        }
        return "redirect:/admin/types";
    }

    // 删除分类
    @GetMapping("/types/{id}/delete")
    public String deleteType(@PathVariable Long id, RedirectAttributes attributes){
//        int res  = typeService.deleteById(id);
//        if(res==0){
//            attributes.addFlashAttribute("message", "删除失败,有博客绑定该分类！");
//        }else {
//            attributes.addFlashAttribute("message", "删除成功");
//        }
        try {
            typeService.deleteById(id);
            attributes.addFlashAttribute("message", "删除成功");
        }catch (Exception e){
            attributes.addFlashAttribute("message", "删除失败,有博客绑定该分类！");
        }
        return "redirect:/admin/types";
    }


}
