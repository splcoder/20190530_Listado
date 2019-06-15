package com.example.a2019_05_30_listado.data;

public class MemberOperation {

	private Object		member;
	private MemberType	type;

	public MemberOperation( Object member, MemberType type ) {
		this.member = member;
		this.type = type;
	}

	public Object getMember() {
		return member;
	}

	public void setMember(Object member) {
		this.member = member;
	}

	public MemberType getType() {
		return type;
	}

	public void setType(MemberType type) {
		this.type = type;
	}
}
