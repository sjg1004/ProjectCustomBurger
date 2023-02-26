package com.green.nowon.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@SequenceGenerator(name = "gen_item", sequenceName = "seq_item", initialValue = 1, allocationSize = 1)
@Table(name = "burger_item")
@Entity
public class ItemEntity {
	
	@Id
	@GeneratedValue(generator = "gen_item" ,strategy = GenerationType.SEQUENCE)
	private long ino;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String content;
	
	@Column(nullable = false)
	private int price;
	
	@Column(nullable = false)
	private int stock; 
	
	@Builder.Default
	@OneToMany(mappedBy = "item")
	private List<ItemListImg> imgs=new ArrayList<>();
	
	public ItemListImg defImg() {
		for(ItemListImg img:imgs) {
			if(img.isDefImg()) return img;
				
		}
		return imgs.get(0);
	}
	
	
	//boolean isSale;
}
