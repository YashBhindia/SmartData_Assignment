package com.smartdatasolutions.test.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberExporter;
import com.smartdatasolutions.test.MemberFileConverter;
import com.smartdatasolutions.test.MemberImporter;

public class Main extends MemberFileConverter {

	@Override
	protected MemberExporter getMemberExporter() {
		// TODO
		return new MemberExporterImpl();
	}

	@Override
	protected MemberImporter getMemberImporter() {
		// TODO
		return new MemberImporterImpl();
	}

	@Override
	protected List<Member> getNonDuplicateMembers(List<Member> membersFromFile) {

		// TODO
		Set<String> seenIds = new HashSet<>();
		List<Member> uniqueMembers = new ArrayList<>();

		for (Member member : membersFromFile) {
			if (!seenIds.contains(member.getId())) {
				seenIds.add(member.getId());
				uniqueMembers.add(member);
			}
		}
		return uniqueMembers;
	}

	@Override
	protected Map<String, List<Member>> splitMembersByState(List<Member> validMembers) {
		// TODO
		Map<String, List<Member>> membersByState = new HashMap<>();

		for (Member member : validMembers) {
			String state = member.getState();
			membersByState.computeIfAbsent(state, k -> new ArrayList<>()).add(member);
		}

		return membersByState;
	}

	public static void main(String[] args) {
		// TODO
		try {
			File inputFile = new File("Members.txt");
			String outputFilePath = "C:\\Users\\user\\Desktop\\output";
			String outputFileName = "outputFile.csv";

			Main converter = new Main();
			converter.convert(inputFile, outputFilePath, outputFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
