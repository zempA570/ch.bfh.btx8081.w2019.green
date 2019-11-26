import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-date-picker/src/vaadin-date-picker.js';
import '@vaadin/vaadin-radio-button/src/vaadin-radio-group.js';
import '@vaadin/vaadin-radio-button/src/vaadin-radio-button.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class CreateTodo extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; justify-content: center; align-items: center;">
 <label id="label">Aufgabe erstellen</label>
 <vaadin-text-field label="Aufgabe" placeholder="Text" id="aufgabe"></vaadin-text-field>
 <vaadin-date-picker label="Datum" placeholder="Datum waehlen" id="datum"></vaadin-date-picker>
 <vaadin-radio-group value="foo" id="vaadinRadioGroup" style="align-self: center; flex-shrink: 0;">
  <vaadin-radio-button name="foo" id="vaadinRadioButton">
    woechentlich 
  </vaadin-radio-button>
  <vaadin-radio-button name="bar" id="vaadinRadioButton1">
    monatlich 
  </vaadin-radio-button>
  <vaadin-radio-button name="baz" id="vaadinRadioButton2" tabindex="0" checked>
    jaehrlich 
  </vaadin-radio-button>
  <vaadin-radio-button name="baz" checked id="vaadinRadioButton3">
    einmalig 
  </vaadin-radio-button>
 </vaadin-radio-group>
 <vaadin-horizontal-layout id="vaadinHorizontalLayout">
  <vaadin-button id="vaadinButton" anlegen="">
   <label id="label1">anlegen</label>
  </vaadin-button>
  <vaadin-button id="vaadinButton" anlegen="">
   <label id="label1">entfernen</label>
  </vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'create-todo';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(CreateTodo.is, CreateTodo);
