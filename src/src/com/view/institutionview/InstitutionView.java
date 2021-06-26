package com.view.institutionview;

public class InstitutionView {
    private final InstitutionIcon institutionIcon;
    private final InstitutionPanel institutionPanel;

    public InstitutionIcon getInstitutionIcon() {
        return institutionIcon;
    }

    public InstitutionPanel getInstitutionPanel() {
        return institutionPanel;
    }

    public InstitutionView(InstitutionIcon institutionIcon, InstitutionPanel institutionPanel){
        this.institutionPanel = institutionPanel;
        this.institutionIcon = institutionIcon;
    }
}
