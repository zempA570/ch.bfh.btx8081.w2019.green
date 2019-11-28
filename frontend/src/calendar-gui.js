import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-date-picker/src/vaadin-date-picker.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-area.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-time-picker/src/vaadin-time-picker.js';
import '@vaadin/vaadin-date-picker/src/vaadin-month-calendar.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-layout.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-item.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';

class CalendarGui extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; justify-content: flex-start;">
 <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout">
  <vaadin-button theme="tertiary" id="backButton">
    &lt; Back 
  </vaadin-button>
  <label id="titleLabel" style="align-self: center;">New Calendar Entry </label>
 </vaadin-horizontal-layout>
 <vaadin-date-picker label="Pick a Date" placeholder="Pick a date" id="calendarDatePicker" style="align-self: center;"></vaadin-date-picker>
 <vaadin-time-picker id="vaadinTimePicker" style="align-self: center;" placeholder="Time"></vaadin-time-picker>
 <vaadin-month-calendar></vaadin-month-calendar>
 <vaadin-text-area label="Write a description" placeholder="Add an appointment" id="appointmentTextField" style="align-self: center;"></vaadin-text-area>
 <vaadin-horizontal-layout theme="spacing" id="horizontalLayoutSpacing" style="align-self: center;">
  <vaadin-button theme="primary" id="addButton">
    Add 
  </vaadin-button>
  <vaadin-button theme="primary error" id="cancelButton">
    Cancel 
  </vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
<vaadin-form-layout style="width: 100%; height: 100%;">
 <vaadin-form-item>
  <label slot="label">First Name</label>
  <vaadin-text-field class="full-width" value="Jane"></vaadin-text-field>
 </vaadin-form-item>
 <vaadin-form-item>
  <label slot="label">Last Name</label>
  <vaadin-text-field class="full-width" value="Doe"></vaadin-text-field>
 </vaadin-form-item>
 <vaadin-form-item>
  <label slot="label">Email</label>
  <vaadin-text-field class="full-width" value="jane.doe@example.com"></vaadin-text-field>
 </vaadin-form-item>
</vaadin-form-layout>
<vaadin-month-calendar id="monthCalendar" disabled show-week-numbers></vaadin-month-calendar>
`;
    }

    static get is() {
        return 'calendar-gui';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(CalendarGui.is, CalendarGui);
