/*
 * Copyright 2009 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.query.client.plugins;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.query.client.JSArray;
import com.google.gwt.query.client.Plugin;
import com.google.gwt.user.client.Event;
import com.google.gwt.query.client.LazyBase;

public interface LazyEvents<T> extends LazyBase<T>{

  /**
   * Binds a set of handlers to a particular Event for each matched element.
   * 
   * The event handlers are passed as Functions that you can use to prevent
   * default behavior. To stop both default action and event bubbling, the
   * function event handler has to return false.
   * 
   * You can pass an additional Object data to your Function as the second
   * parameter
   * 
   */
  LazyEvents<T> bind(int eventbits, Object data, Function...funcs);

  /**
   * Binds a handler to a particular Event (like Event.ONCLICK) for each matched
   * element. The handler is executed only once for each element.
   *
   * The event handler is passed as a Function that you can use to prevent
   * default behavior. To stop both default action and event bubbling, the
   * function event handler has to return false.
   *
   * You can pass an additional Object data to your Function as the second
   * parameter
   */  
  LazyEvents<T> one(int eventbits, Object data, Function f);

  /**
   * Execute all handlers and behaviors attached to the matched elements for the given event types.
   * 
   * Different event types can be passed joining these using the or bit wise operator.
   * 
   * For keyboard events you can pass a second parameter which represents 
   * the key-code of the pushed key. 
   * 
   * Example: fire(Event.ONCLICK | Event.ONFOCUS)
   * Example: fire(Event.ONKEYDOWN. 'a');
   */
  LazyEvents<T> trigger(int eventbits, int... keys);

  /**
   * Trigger a html event in all matched elements.
   * 
   * @param htmlEvent
   *    An string representing the html event desired 
   */
  LazyEvents<T> triggerHtmlEvent(String htmlEvent);

  /**
   * Removes all handlers, that matches the events bits passed, from each
   * element.
   * 
   * Example: unbind(Event.ONCLICK | Event.ONMOUSEOVER)
   */
  LazyEvents<T> unbind(int eventbits);

}