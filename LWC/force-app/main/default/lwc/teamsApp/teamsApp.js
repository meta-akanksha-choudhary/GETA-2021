import { LightningElement, track, wire } from 'lwc';
import getTeamList from '@salesforce/apex/CustomController.getTeamList';
import getAllTeamMembers from '@salesforce/apex/CustomController.getAllTeamMembers';
import { ShowToastEvent } from 'lightning/platformShowToastEvent';
import { createRecord} from "lightning/uiRecordApi";

export default class TeamsApp extends LightningElement {
	@track teamMemberList = [];
	@wire(getTeamList)
	teams;

	@wire(getAllTeamMembers)
	getTeamMembers({data, error}){
		if(data){
			this.teamMemberList = data;
		}
	}

	handleSubmit(event) {
		const fields = {};
		fields['Name'] = event.detail.memberName
		fields['Team__c'] = event.detail.teamId.split(':')[0]
		fields['Skills__c'] = event.detail.memberSkills;
		const recordInput = {
			apiName: 'Team_Member__c',
			fields,
		};
		createRecord(recordInput)
			.then(() => {
				this.showSuccessToast();
					this.teamMemberList = [{
						'Name':event.detail.memberName,
						'Skills__c':event.detail.memberSkills,
						'Team__r': {
							'Name': event.detail.teamId.split(':')[1]
						}
					},
					...this.teamMemberList
					];
			})
			.catch((error) => {
				this.showErrorToast();
			});
	}
	showSuccessToast() {
		this.dispatchEvent(
			new ShowToastEvent({
				title: 'Successfully!',
				message: 'Record inserted successfully.',
				variant: 'success',
				mode: 'pester'
			})
		);
	}
	showErrorToast() {
		this.dispatchEvent(
			new ShowToastEvent({
				title: 'Failed!',
				message: 'Record insertion failure.',
				variant: 'error',
				mode: 'pester'
			})
		);
	}
}