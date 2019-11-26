import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-list-box/src/vaadin-list-box.js';
import '@vaadin/vaadin-item/src/vaadin-item.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class TodoList extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;" id="vaadinVerticalLayout" content="Datum">
 <label id="label">Aufgabenliste</label>
 <vaadin-horizontal-layout id="vaadinHorizontalLayout" style="align-self: flex-start;">
  <label id="label1"></label>
  <vaadin-list-box>
   <b>Einmalig</b>
   <vaadin-item>
    Kuchen kaufen
   </vaadin-item>
   <vaadin-item style="flex-grow: 0;">
    Paket beim Post abholen
   </vaadin-item>
   <hr>
  </vaadin-list-box>
  <label style="flex-grow: 0; flex-shrink: 0;"></label>
  <vaadin-list-box id="vaadinListBox">
   <b>Datum</b>
   <vaadin-item>
    05.11.2019
   </vaadin-item>
   <vaadin-item>
    07.11.2010
   </vaadin-item>
   <hr>
   <vaadin-item></vaadin-item>
  </vaadin-list-box>
 </vaadin-horizontal-layout>
 <label id="label2"></label>
 <vaadin-list-box id="vaadinListBox1">
  <b>Woechentlich</b>
  <vaadin-item id="vaadinItem2">
   Gemeinsam Abendessen
   <vaadin-checkbox id="vaadinCheckbox"></vaadin-checkbox>
  </vaadin-item>
  <vaadin-item style="flex-grow: 0;" id="vaadinItem3">
   Spazieren gehen
  </vaadin-item>
  <hr>
 </vaadin-list-box>
 <vaadin-list-box id="vaadinListBox2">
  <b>Monatlich</b>
  <vaadin-item id="vaadinItem">
   Wohnung Pieterlen
   <vaadin-checkbox id="vaadinCheckbox3"></vaadin-checkbox>
  </vaadin-item>
  <vaadin-item style="flex-grow: 0;" id="vaadinItem1">
   Coiffeur Termin
   <vaadin-checkbox id="vaadinCheckbox2"></vaadin-checkbox>
  </vaadin-item>
  <hr id="hr">
 </vaadin-list-box>
 <vaadin-list-box id="vaadinListBox3">
  <b>Jaerlich</b>
  <vaadin-item id="vaadinItem4">
   Steuererklaerung
   <vaadin-checkbox id="vaadinCheckbox1"></vaadin-checkbox>
  </vaadin-item>
  <hr id="hr1">
 </vaadin-list-box>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'todo-list';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(TodoList.is, TodoList);
