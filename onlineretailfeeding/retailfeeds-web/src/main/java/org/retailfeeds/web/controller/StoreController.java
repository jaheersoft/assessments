package org.retailfeeds.web.controller;

import java.util.ArrayList;
import java.util.List;
import org.retailfeeds.web.model.Store;
import org.retailfeeds.web.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StoreController {

	@Autowired
	private StoreRepository storeRepository;

	@GetMapping("/stores")
	public String getAll(Model model, @RequestParam(required = false) String keyword,
			@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "6") int size,
			@RequestParam(defaultValue = "id,asc") String[] sort) {
		try {
			List<Store> stores = new ArrayList<>();

			String sortField = sort[0];
			String sortDirection = sort[1];

			Direction direction = sortDirection.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
			Order order = new Order(direction, sortField);

			Pageable pageable = PageRequest.of(page - 1, size, Sort.by(order));

			Page<Store> pageTuts;
			if (keyword == null) {
				pageTuts = storeRepository.findAll(pageable);
			} else {
				pageTuts = storeRepository.findByProductNameContainingIgnoreCase(keyword, pageable);
				model.addAttribute("keyword", keyword);
			}

			stores = pageTuts.getContent();

			model.addAttribute("stores", stores);
			model.addAttribute("currentPage", pageTuts.getNumber() + 1);
			model.addAttribute("totalItems", pageTuts.getTotalElements());
			model.addAttribute("totalPages", pageTuts.getTotalPages());
			model.addAttribute("pageSize", size);
			model.addAttribute("sortField", sortField);
			model.addAttribute("sortDirection", sortDirection);
			model.addAttribute("reverseSortDirection", sortDirection.equals("asc") ? "desc" : "asc");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
		}

		return "stores";
	}

	@GetMapping("/stores/new")
	public String addStore(Model model) {
		Store store = new Store();
		model.addAttribute("store", store);
		model.addAttribute("pageTitle", "Create new Store");

		return "store_form";
	}

	@PostMapping("/stores/save")
	public String saveStore(Store store, RedirectAttributes redirectAttributes) {
		try {
			storeRepository.save(store);
			redirectAttributes.addFlashAttribute("message", "The Store has been saved successfully!");
		} catch (Exception e) {
			redirectAttributes.addAttribute("message", e.getMessage());
		}
		return "redirect:/stores";
	}

	@GetMapping("/stores/{id}")
	public String editStore(@PathVariable("id") String id, Model model, RedirectAttributes redirectAttributes) {
		try {
			Store store = storeRepository.findById(id).get();
			model.addAttribute("store", store);
			model.addAttribute("pageTitle", "Edit Store (ID: " + id + ")");
			return "store_form";
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", e.getMessage());
			return "redirect:/stores";
		}
	}

	@GetMapping("/stores/delete/{id}")
	public String deleteStore(@PathVariable("id") String id, Model model, RedirectAttributes redirectAttributes) {
		try {
			storeRepository.deleteById(id);
			redirectAttributes.addFlashAttribute("message",
					"The Store with id=" + id + " has been deleted successfully!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", e.getMessage());
		}
		return "redirect:/stores";
	}

	/*
	 * @GetMapping("/stores/{id}/published/{status}") public String
	 * updateTutorialPublishedStatus(@PathVariable("id") Integer
	 * id, @PathVariable("status") boolean published, Model model,
	 * RedirectAttributes redirectAttributes) { try {
	 * storeRepository.updatePublishedStatus(id, published);
	 * 
	 * String status = published ? "published" : "disabled"; String message =
	 * "The Tutorial id=" + id + " has been " + status;
	 * 
	 * redirectAttributes.addFlashAttribute("message", message); } catch (Exception
	 * e) { redirectAttributes.addFlashAttribute("message", e.getMessage()); }
	 * 
	 * return "redirect:/tutorials"; }
	 */
}
