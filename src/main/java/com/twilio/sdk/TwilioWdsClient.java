package com.twilio.sdk;

import com.twilio.sdk.resource.factory.wds.ActivityFactory;
import com.twilio.sdk.resource.factory.wds.TaskFactory;
import com.twilio.sdk.resource.factory.wds.TaskQueueFactory;
import com.twilio.sdk.resource.factory.wds.WorkerFactory;
import com.twilio.sdk.resource.factory.wds.WorkflowFactory;
import com.twilio.sdk.resource.factory.wds.WorkspaceFactory;
import com.twilio.sdk.resource.instance.wds.Activity;
import com.twilio.sdk.resource.instance.wds.QueueStatistics;
import com.twilio.sdk.resource.instance.wds.Reservation;
import com.twilio.sdk.resource.instance.wds.Task;
import com.twilio.sdk.resource.instance.wds.TaskQueue;
import com.twilio.sdk.resource.instance.wds.Worker;
import com.twilio.sdk.resource.instance.wds.WorkerStatistics;
import com.twilio.sdk.resource.instance.wds.WorkersStatistics;
import com.twilio.sdk.resource.instance.wds.Workflow;
import com.twilio.sdk.resource.instance.wds.WorkflowStatistics;
import com.twilio.sdk.resource.instance.wds.Workspace;
import com.twilio.sdk.resource.list.wds.ActivityList;
import com.twilio.sdk.resource.list.wds.QueueListStatistics;
import com.twilio.sdk.resource.list.wds.ReservationList;
import com.twilio.sdk.resource.list.wds.TaskList;
import com.twilio.sdk.resource.list.wds.TaskQueueList;
import com.twilio.sdk.resource.list.wds.WorkerList;
import com.twilio.sdk.resource.list.wds.WorkflowList;
import com.twilio.sdk.resource.list.wds.WorkspaceList;

import java.util.HashMap;
import java.util.Map;

/**
 * The client class that access http://wds.twilio.com.
 */
public class TwilioWdsClient extends TwilioClient {

	public static final String DEFAULT_VERSION = "v1";

	public TwilioWdsClient(final String accountSid, final String authToken) {
		super(accountSid, authToken, "http://wds.twilio.com");
	}

	/**
	 * Create an {@link com.twilio.sdk.resource.instance.wds.Activity}.
	 *
	 * @param properties activity properties
	 * @return created activity
	 * @throws TwilioRestException
	 */
	public Activity createActivity(final String workspaceSid, final Map<String, String> properties) throws
	                                                                                                TwilioRestException {
		ActivityFactory activityFactory = new ActivityList(this, workspaceSid);
		return activityFactory.create(properties);
	}

	/**
	 * Create an {@link com.twilio.sdk.resource.instance.wds.TaskQueue}.
	 *
	 * @param properties queue properties
	 * @return created queue
	 * @throws TwilioRestException
	 */
	public TaskQueue createTaskQueue(final String workspaceSid, final Map<String, String> properties) throws
	                                                                                          TwilioRestException {
		TaskQueueFactory taskQueueFactory = new TaskQueueList(this, workspaceSid);
		return taskQueueFactory.create(properties);
	}

	/**
	 * Create an {@link com.twilio.sdk.resource.instance.wds.Task}.
	 *
	 * @param properties task properties
	 * @return created task
	 * @throws TwilioRestException
	 */
	public Task createTask(final String workspaceSid, final Map<String, String> properties) throws TwilioRestException {
		TaskFactory taskFactory = new TaskList(this, workspaceSid);
		return taskFactory.create(properties);
	}

	/**
	 * Create an {@link com.twilio.sdk.resource.instance.wds.Worker}.
	 *
	 * @param properties task properties
	 * @return created worker
	 * @throws TwilioRestException
	 */
	public Worker createWorker(final String workspaceSid, final Map<String, String> properties) throws
	                                                                                            TwilioRestException {
		WorkerFactory factory = new WorkerList(this, workspaceSid);
		return factory.create(properties);
	}

	/**
	 * Create an {@link com.twilio.sdk.resource.instance.wds.Workflow}.
	 *
	 * @param properties task properties
	 * @return created workflow
	 * @throws TwilioRestException
	 */
	public Workflow createWorkflow(final String workspaceSid, final Map<String, String> properties) throws
	                                                                                                TwilioRestException {
		WorkflowFactory factory = new WorkflowList(this, workspaceSid);
		return factory.create(properties);
	}

	/**
	 * Create a {@link com.twilio.sdk.resource.instance.wds.Workspace}.
	 *
	 * @param properties workspace properties
	 * @return created workspace
	 * @throws TwilioRestException
	 */
	public Workspace createWorkspace(final Map<String, String> properties) throws TwilioRestException {
		WorkspaceFactory workspaceFactory = new WorkspaceList(this);
		return workspaceFactory.create(properties);
	}

	/**
	 * Deletes an activity.
	 *
	 * @param workspaceSid the workspace sid
	 * @param activitySid the activity sid
	 * @return true, if successful
	 * @throws TwilioRestException the twilio rest exception
	 */
	public boolean deleteActivity(final String workspaceSid, final String activitySid) throws TwilioRestException {
		TwilioRestResponse response = safeRequest(
				"/" + TwilioWdsClient.DEFAULT_VERSION + "/Accounts/" + getAccountSid() + "/Workspaces/" + workspaceSid +
				"/Activities/" + activitySid, "DELETE", (Map) null);

		return !response.isError();
	}

	/**
	 * Deletes a queue.
	 *
	 * @param workspaceSid the workspace sid
	 * @param queueSid the queue sid
	 * @return true, if successful
	 * @throws TwilioRestException the twilio rest exception
	 */
	public boolean deleteTaskQueue(final String workspaceSid, final String queueSid) throws TwilioRestException {
		TwilioRestResponse response = safeRequest(
				"/" + TwilioWdsClient.DEFAULT_VERSION + "/Accounts/" + getAccountSid() + "/Workspaces/" + workspaceSid +
				"/TaskQueues/" + queueSid, "DELETE", (Map) null);

		return !response.isError();
	}

	/**
	 * Deletes a task.
	 *
	 * @param workspaceSid the workspace sid
	 * @param taskSid the task sid
	 * @return true, if successful
	 * @throws TwilioRestException the twilio rest exception
	 */
	public boolean deleteTask(final String workspaceSid, final String taskSid) throws TwilioRestException {
		TwilioRestResponse response = safeRequest(
				"/" + TwilioWdsClient.DEFAULT_VERSION + "/Accounts/" + getAccountSid() + "/Workspaces/" + workspaceSid +
				"/Tasks/" + taskSid, "DELETE", (Map) null);

		return !response.isError();
	}

	/**
	 * Deletes a worker.
	 *
	 * @param workspaceSid the workspace sid
	 * @param workerSid the worker sid
	 * @return true, if successful
	 * @throws TwilioRestException the twilio rest exception
	 */
	public boolean deleteWorker(final String workspaceSid, final String workerSid) throws TwilioRestException {
		TwilioRestResponse response = safeRequest(
				"/" + TwilioWdsClient.DEFAULT_VERSION + "/Accounts/" + getAccountSid() + "/Workspaces/" + workspaceSid +
				"/Workers/" + workerSid, "DELETE", (Map) null);

		return !response.isError();
	}

	/**
	 * Deletes a workflow.
	 *
	 * @param workspaceSid the workspace sid
	 * @param workflowSid the workflow sid
	 * @return true, if successful
	 * @throws TwilioRestException the twilio rest exception
	 */
	public boolean deleteWorkflow(final String workspaceSid, final String workflowSid) throws TwilioRestException {
		TwilioRestResponse response = safeRequest(
				"/" + TwilioWdsClient.DEFAULT_VERSION + "/Accounts/" + getAccountSid() + "/Workspaces/" + workspaceSid +
				"/Workflows/" + workflowSid, "DELETE", (Map) null);

		return !response.isError();
	}

	/**
	 * Deletes a workspace.
	 *
	 * @param sid the workspace sid
	 * @return true, if successful
	 * @throws TwilioRestException the twilio rest exception
	 */
	public boolean deleteWorkspace(final String sid) throws TwilioRestException {
		TwilioRestResponse response = safeRequest(
				"/" + TwilioWdsClient.DEFAULT_VERSION + "/Accounts/" + getAccountSid() + "/Workspaces/" + sid, "DELETE",
				(Map) null);

		return !response.isError();
	}

	/**
	 * Get the activities.
	 *
	 * @return the activities
	 */
	public ActivityList getActivities(final String workspaceSid) {
		return getActivities(workspaceSid, new HashMap<String, String>(0));
	}

	/**
	 * Get the activities.
	 *
	 * @param workspaceSid the workspace sid
	 * @param filters the filters
	 * @return activities matching the filters
	 */
	public ActivityList getActivities(final String workspaceSid, final Map<String, String> filters) {
		ActivityList list = new ActivityList(this, workspaceSid, filters);
		list.setRequestAccountSid(getAccountSid());
		return list;
	}

	/**
	 * Get an activity instance by sid.
	 *
	 * @param workspaceSid The 34 character sid starting with WS
	 * @param activitySid The 34 character sid starting with WA
	 */
	public Activity getActivity(final String workspaceSid, final String activitySid) {
		Activity activity = new Activity(this, workspaceSid, activitySid);
		activity.setRequestAccountSid(getAccountSid());
		return activity;
	}

	/**
	 * Get a reservation instance by sid.
	 *
	 * @param workspaceSid The 34 character sid starting with WS
	 * @param taskSid The 34 character sid starting with WT
	 * @param reservationSid The 34 character sid starting with WR
	 */
	public Reservation getReservation(final String workspaceSid, final String taskSid, final String reservationSid) {
		Reservation reservation = new Reservation(this, workspaceSid, taskSid, reservationSid);
		reservation.setRequestAccountSid(getAccountSid());
		return reservation;
	}

	/**
	 * Get the reservations.
	 *
	 * @return the reservations
	 */
	public ReservationList getReservations(final String workspaceSid, final String taskSid) {
		return getReservations(workspaceSid, taskSid, new HashMap<String, String>(0));
	}

	/**
	 * Get the reservations.
	 *
	 * @param workspaceSid the workspace sid
	 * @param filters the filters
	 * @return tasks matching the filters
	 */
	public ReservationList getReservations(final String workspaceSid, final String taskSid,
	                                       final Map<String, String> filters) {
		ReservationList list = new ReservationList(this, workspaceSid, taskSid, filters);
		list.setRequestAccountSid(getAccountSid());
		return list;
	}

	/**
	 * Get a queue instance by sid.
	 *
	 * @param workspaceSid The 34 character sid starting with WS
	 * @param queueSid The 34 character sid starting with WQ
	 */
	public TaskQueue getTaskQueue(final String workspaceSid, final String queueSid) {
		TaskQueue taskQueue = new TaskQueue(this, workspaceSid, queueSid);
		taskQueue.setRequestAccountSid(getAccountSid());
		return taskQueue;
	}

	/**
	 * Get the queues.
	 *
	 * @return the queues
	 */
	public TaskQueueList getTaskQueues(final String workspaceSid) {
		return getTaskQueues(workspaceSid, new HashMap<String, String>(0));
	}

	/**
	 * Get the queues.
	 *
	 * @param workspaceSid the workspace sid
	 * @param filters the filters
	 * @return queues matching the filters
	 */
	public TaskQueueList getTaskQueues(final String workspaceSid, final Map<String, String> filters) {
		TaskQueueList list = new TaskQueueList(this, workspaceSid, filters);
		list.setRequestAccountSid(getAccountSid());
		return list;
	}

	/**
	 * Get queues statistics.
	 *
	 * @param workspaceSid The 34 character sid starting with WS
	 * @return queues statistics
	 */
	public QueueListStatistics getQueuesStatistics(final String workspaceSid) {
		return getQueuesStatistics(workspaceSid, null);
	}

	/**
	 * Get queues statistics.
	 *
	 * @param workspaceSid The 34 character sid starting with WS
	 * @param filters the filters
	 * @return queues statistics
	 */
	public QueueListStatistics getQueuesStatistics(final String workspaceSid, final Map<String, String> filters) {
		QueueListStatistics list = new QueueListStatistics(this, workspaceSid, filters);
		list.setRequestAccountSid(getAccountSid());
		return list;
	}

	/**
	 * Get a queue statistics.
	 *
	 * @param workspaceSid The 34 character sid starting with WS
	 * @param queueSid The 34 character sid starting with WQ
	 * @return queue statistics
	 */
	public QueueStatistics getQueueStatistics(final String workspaceSid, final String queueSid) {
		return getQueueStatistics(workspaceSid, queueSid, null);
	}

	/**
	 * Get a queue statistics.
	 *
	 * @param workspaceSid The 34 character sid starting with WS
	 * @param queueSid The 34 character sid starting with WQ
	 * @param filters the filters
	 * @return queue statistics
	 */
	public QueueStatistics getQueueStatistics(final String workspaceSid, final String queueSid,
	                                          final Map<String, String> filters) {
		QueueStatistics queueStatistics = new QueueStatistics(this, workspaceSid, queueSid, filters);
		queueStatistics.setRequestAccountSid(getAccountSid());
		return queueStatistics;
	}

	/**
	 * Get a task instance by sid.
	 *
	 * @param workspaceSid The 34 character sid starting with WS
	 * @param taskSid The 34 character sid starting with WT
	 */
	public Task getTask(final String workspaceSid, final String taskSid) {
		Task task = new Task(this, workspaceSid, taskSid);
		task.setRequestAccountSid(getAccountSid());
		return task;
	}

	/**
	 * Get the tasks.
	 *
	 * @return the tasks
	 */
	public TaskList getTasks(final String workspaceSid) {
		return getTasks(workspaceSid, new HashMap<String, String>(0));
	}

	/**
	 * Get the tasks.
	 *
	 * @param workspaceSid the workspace sid
	 * @param filters the filters
	 * @return tasks matching the filters
	 */
	public TaskList getTasks(final String workspaceSid, final Map<String, String> filters) {
		TaskList list = new TaskList(this, workspaceSid, filters);
		list.setRequestAccountSid(getAccountSid());
		return list;
	}

	/**
	 * Get a worker instance by sid.
	 *
	 * @param workspaceSid The 34 character sid starting with WS
	 * @param workerSid The 34 character sid starting with WT
	 */
	public Worker getWorker(final String workspaceSid, final String workerSid) {
		Worker worker = new Worker(this, workspaceSid, workerSid);
		worker.setRequestAccountSid(getAccountSid());
		return worker;
	}

	/**
	 * Get the workers.
	 *
	 * @return the workers
	 */
	public WorkerList getWorkers(final String workspaceSid) {
		return getWorkers(workspaceSid, new HashMap<String, String>(0));
	}

	/**
	 * Get the workers.
	 *
	 * @param workspaceSid the workspace sid
	 * @param filters the filters
	 * @return tasks matching the filters
	 */
	public WorkerList getWorkers(final String workspaceSid, final Map<String, String> filters) {
		WorkerList list = new WorkerList(this, workspaceSid, filters);
		list.setRequestAccountSid(getAccountSid());
		return list;
	}

	/**
	 * Get workers statistics.
	 *
	 * @param workspaceSid The 34 character sid starting with WS
	 * @return queues statistics
	 */
	public WorkersStatistics getWorkersStatistics(final String workspaceSid) {
		return getWorkersStatistics(workspaceSid, null);
	}

	/**
	 * Get workers statistics.
	 *
	 * @param workspaceSid The 34 character sid starting with WS
	 * @param filters the filters
	 * @return queues statistics
	 */
	public WorkersStatistics getWorkersStatistics(final String workspaceSid, final Map<String, String> filters) {
		WorkersStatistics workersStatistics = new WorkersStatistics(this, workspaceSid, filters);
		workersStatistics.setRequestAccountSid(getAccountSid());
		return workersStatistics;
	}

	/**
	 * Get worker statistics.
	 *
	 * @param workspaceSid The 34 character sid starting with WS
	 * @param workerSid The 34 character sid starting with WW
	 * @return queues statistics
	 */
	public WorkerStatistics getWorkerStatistics(final String workspaceSid, final String workerSid) {
		return getWorkerStatistics(workspaceSid, workerSid, null);
	}

	/**
	 * Get worker statistics.
	 *
	 * @param workspaceSid The 34 character sid starting with WS
	 * @param workerSid The 34 character sid starting with WW
	 * @param filters the filters
	 * @return queues statistics
	 */
	public WorkerStatistics getWorkerStatistics(final String workspaceSid, final String workerSid,
	                                            final Map<String, String> filters) {
		WorkerStatistics workerStatistics = new WorkerStatistics(this, workspaceSid, workerSid, filters);
		workerStatistics.setRequestAccountSid(getAccountSid());
		return workerStatistics;
	}

	/**
	 * Get a workflow instance by sid.
	 *
	 * @param workspaceSid The 34 character sid starting with WS
	 * @param workflowSid The 34 character sid starting with WF
	 */
	public Workflow getWorkflow(final String workspaceSid, final String workflowSid) {
		Workflow workflow = new Workflow(this, workspaceSid, workflowSid);
		workflow.setRequestAccountSid(getAccountSid());
		return workflow;
	}

	/**
	 * Get the workflows.
	 *
	 * @return the workflows
	 */
	public WorkflowList getWorkflows(final String workspaceSid) {
		return getWorkflows(workspaceSid, new HashMap<String, String>(0));
	}

	/**
	 * Get the workflows.
	 *
	 * @param workspaceSid the workspace sid
	 * @param filters the filters
	 * @return tasks matching the filters
	 */
	public WorkflowList getWorkflows(final String workspaceSid, final Map<String, String> filters) {
		WorkflowList list = new WorkflowList(this, workspaceSid, filters);
		list.setRequestAccountSid(getAccountSid());
		return list;
	}

	/**
	 * Get workflow statistics.
	 *
	 * @param workspaceSid The 34 character sid starting with WS
	 * @param workflowSid The 34 character sid starting with WF
	 * @return queues statistics
	 */
	public WorkflowStatistics getWorkflowStatistics(final String workspaceSid, final String workflowSid) {
		return getWorkflowStatistics(workspaceSid, workflowSid, null);
	}

	/**
	 * Get workflow statistics.
	 *
	 * @param workspaceSid The 34 character sid starting with WS
	 * @param workflowSid The 34 character sid starting with WF
	 * @param filters the filters
	 * @return queues statistics
	 */
	public WorkflowStatistics getWorkflowStatistics(final String workspaceSid, final String workflowSid,
	                                                final Map<String, String> filters) {
		WorkflowStatistics workflowStatistics = new WorkflowStatistics(this, workspaceSid, workflowSid, filters);
		workflowStatistics.setRequestAccountSid(getAccountSid());
		return workflowStatistics;
	}

	/**
	 * Get a workspace instance by sid
	 *
	 * @param sid The 34 character sid starting with WS
	 */
	public Workspace getWorkspace(final String sid) {
		Workspace workspace = new Workspace(this, sid);
		workspace.setRequestAccountSid(getAccountSid());
		return workspace;
	}

	/**
	 * Get the workspaces.
	 *
	 * @return the workspaces
	 */
	public WorkspaceList getWorkspaces() {
		return getWorkspaces(new HashMap<String, String>(0));
	}

	/**
	 * Get the workspaces.
	 *
	 * @param filters the filters
	 * @return workspaces matching the filters
	 */
	public WorkspaceList getWorkspaces(final Map<String, String> filters) {
		WorkspaceList list = new WorkspaceList(this, filters);
		list.setRequestAccountSid(getAccountSid());
		return list;
	}

}
